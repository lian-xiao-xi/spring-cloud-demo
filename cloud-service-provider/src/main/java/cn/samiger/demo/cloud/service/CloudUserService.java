package cn.samiger.demo.cloud.service;

import cn.samiger.demo.cloud.model.CloudUser;
import cn.samiger.demo.cloud.repository.CloudUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudUserService {
  @Autowired
  private CloudUserRepository repository;
  
  public List<CloudUser> getAll() {
    return repository.findAll();
  }
}
