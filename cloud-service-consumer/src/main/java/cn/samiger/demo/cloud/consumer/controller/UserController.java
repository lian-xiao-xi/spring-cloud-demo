package cn.samiger.demo.cloud.consumer.controller;

import cn.samiger.demo.cloud.consumer.pojo.CloudUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer/user")
public class UserController {
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private RestTemplate restTemplate;
  
  // TODO 解决报错
  @GetMapping("/one/{id}")
  public CloudUser allUsers(@PathVariable Long id) {
    List<ServiceInstance> instances = discoveryClient.getInstances("service-provider");
    ServiceInstance serviceInstance = instances.get(0);
    String baseUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/api/user/one/" + id;
    return this.restTemplate.getForObject(baseUrl, CloudUser.class);
  }
}
