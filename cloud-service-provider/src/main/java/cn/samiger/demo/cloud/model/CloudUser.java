package cn.samiger.demo.cloud.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cloud_user", indexes = {
  @Index(name = "idx_login_name", columnList = "loginName", unique = true),
})
@Getter
@Setter
@JsonIgnoreProperties({"password", "salt"})
public class CloudUser {
  @Id
  @Column(updatable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 60, nullable = false)
  private String loginName;
  
  @Column(length = 64, nullable = false)
  private String password;
  
  @Column(length = 50)
  private String nickname;
  
  @Column(length = 128, nullable = false)
  private String salt;
  
  @Column(length = 500)
  private String headImgUrl;
  
}
