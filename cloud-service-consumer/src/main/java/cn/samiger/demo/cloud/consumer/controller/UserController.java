package cn.samiger.demo.cloud.consumer.controller;

import cn.samiger.demo.cloud.consumer.pojo.CloudUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consumer/user")
public class UserController {
  @Autowired
  private RestTemplate restTemplate;
  
  // 使用了负载均衡
  @GetMapping("/one/{id}")
  public CloudUser allUsers(@PathVariable Long id) {
    String baseUrl = "http://service-provider/api/user/one/"+id;
    return this.restTemplate.getForObject(baseUrl, CloudUser.class);
  }
}
