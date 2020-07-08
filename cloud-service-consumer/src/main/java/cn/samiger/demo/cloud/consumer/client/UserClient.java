package cn.samiger.demo.cloud.consumer.client;

import cn.samiger.demo.cloud.consumer.pojo.CloudUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "service-provider", fallback = UserClientFallback.class)
public interface UserClient {
  
  @GetMapping("/api/user/one/{id}")
  CloudUser getUser(@PathVariable Long id);
  
}
