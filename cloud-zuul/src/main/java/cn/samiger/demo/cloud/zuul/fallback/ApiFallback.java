package cn.samiger.demo.cloud.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ApiFallback implements FallbackProvider {
  
  @Override
  public String getRoute() {
    return "*";
  }
  
  @Override
  public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
    String bodyText = "{\"code\": 999,\"message\": \"Service Error:\"}";
    return new GatewayClientResponse(HttpStatus.OK, bodyText, new HttpHeaders());
  }
  
  private static class GatewayClientResponse implements ClientHttpResponse {
    
    private final HttpStatus httpStatus;
    private final String bodyText;
    private final HttpHeaders httpHeaders;
  
    public GatewayClientResponse(HttpStatus httpStatus, String bodyText, HttpHeaders httpHeaders) {
      this.httpStatus = httpStatus;
      this.bodyText = bodyText;
      this.httpHeaders = httpHeaders;
    }
  
    @Override
    public HttpStatus getStatusCode() throws IOException {
      return this.httpStatus;
    }
  
    @Override
    public int getRawStatusCode() throws IOException {
      return this.httpStatus.value();
    }
  
    @Override
    public String getStatusText() throws IOException {
      return this.httpStatus.getReasonPhrase();
    }
  
    @Override
    public void close() {
      try {
        this.getBody().close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  
    @Override
    public InputStream getBody() throws IOException {
      return new ByteArrayInputStream(this.bodyText.getBytes());
    }
  
    @Override
    public HttpHeaders getHeaders() {
      return this.httpHeaders;
    }
  }
}
