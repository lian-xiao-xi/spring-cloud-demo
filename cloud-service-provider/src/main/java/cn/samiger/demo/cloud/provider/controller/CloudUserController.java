package cn.samiger.demo.cloud.provider.controller;

import cn.samiger.demo.cloud.provider.model.CloudUser;
import cn.samiger.demo.cloud.provider.service.CloudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class CloudUserController {
  @Autowired
  private CloudUserService userService;
  
  @GetMapping("/all")
  public List<CloudUser> allUsers() {
    return userService.getAll();
  }
  
  @GetMapping("/one/{id}")
  public CloudUser one(@PathVariable Long id) {
    // 模拟连接超时，触发消费方容错框架的服务降级
    if(id == 2) {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return userService.getById(id);
  }
}
