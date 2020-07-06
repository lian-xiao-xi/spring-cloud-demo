package cn.samiger.demo.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudServiceConsumerApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(CloudServiceConsumerApplication.class, args);
  }
  
}
