package cn.samiger.demo.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
//@SpringCloudApplication // 组合注解
public class CloudServiceConsumerApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(CloudServiceConsumerApplication.class, args);
  }
  
}
