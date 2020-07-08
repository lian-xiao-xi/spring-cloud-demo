package cn.samiger.demo.cloud.consumer.controller;

import cn.samiger.demo.cloud.consumer.client.UserClient;
import cn.samiger.demo.cloud.consumer.pojo.CloudUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer/user")
public class UserController {
  
  // feign 框架内部已经将 @FeignClient 标记的接口设为 @Primary 的，所以这里不用关于 idea 提示的错误
  @Autowired
  private UserClient userClient;
  
  @GetMapping("/one/{id}")
  public CloudUser allUsers(@PathVariable Long id) {
    return userClient.getUser(id);
  }
  
}
