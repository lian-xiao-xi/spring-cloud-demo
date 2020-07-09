package cn.samiger.demo.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class LoginFilter extends ZuulFilter {
  @Override
  public String filterType() {
    return "pre";
  }
  
  @Override
  public int filterOrder() {
    return 100;
  }
  
  @Override
  public boolean shouldFilter() {
    return true;
  }
  
  @Override
  public Object run() throws ZuulException {
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletRequest request = context.getRequest();
    HttpSession session = request.getSession();
    Object token = session.getAttribute("token");
    if(StringUtils.isEmpty(token)) {
//      context.setSendZuulResponse(false);
//      context.setResponseBody("{\"status\":\"401\", \"text\":\"request error!\"}");
    }
    context.set("token", token);
    return null;
  }
}
