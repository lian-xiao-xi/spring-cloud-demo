package cn.samiger.demo.cloud.consumer.client;

import cn.samiger.demo.cloud.consumer.pojo.CloudUser;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
  @Override
  public CloudUser getUser(Long id) {
    CloudUser user = new CloudUser();
    return user;
  }
}
