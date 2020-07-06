package cn.samiger.demo.cloud.provider.service;

import cn.samiger.demo.cloud.provider.model.CloudUser;
import cn.samiger.demo.cloud.provider.repository.CloudUserRepository;
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
  
  public CloudUser getById(Long id) {
    return repository.findById(id).orElse(null);
  }
}
