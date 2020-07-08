package cn.samiger.demo.cloud.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer/user")
@DefaultProperties(defaultFallback = "fallback") // 定义类全局的熔断方法
public class UserController {
  @Autowired
  private RestTemplate restTemplate;
  
  @GetMapping("/one/{id}")
  @HystrixCommand // 标记该方法需要熔断
  public String allUsers(@PathVariable Long id) {
    String baseUrl = "http://service-provider/api/user/one/"+id;
    return this.restTemplate.getForObject(baseUrl, String.class);
  }
  
  public String fallback() {
    return "服务正忙。。。请稍候再试";
  }
}
