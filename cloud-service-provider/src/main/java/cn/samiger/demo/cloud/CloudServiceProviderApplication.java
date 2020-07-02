package cn.samiger.demo.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class CloudServiceProviderApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(CloudServiceProviderApplication.class, args);
  }
  
}
