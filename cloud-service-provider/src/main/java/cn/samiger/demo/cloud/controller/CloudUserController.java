package cn.samiger.demo.cloud.controller;

import cn.samiger.demo.cloud.model.CloudUser;
import cn.samiger.demo.cloud.service.CloudUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
