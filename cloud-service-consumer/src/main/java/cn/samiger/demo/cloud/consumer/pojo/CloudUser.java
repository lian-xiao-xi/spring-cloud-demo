package cn.samiger.demo.cloud.consumer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({"password", "salt"})
public class CloudUser {
  private Long id;
  
  private String loginName;
  
  private String password;
  
  private String nickname;
  
  private String salt;
  
  private String headImgUrl;
  
}
