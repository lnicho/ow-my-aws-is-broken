package com.lnicho.owmyaws.service;

import com.lnicho.owmyaws.model.User;
import com.lnicho.owmyaws.repository.UserRepository;
import com.lnicho.owmyaws.service.exception.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User GetUserById(long userId)
  {
    return userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User " + userId + " does not exist."));
  }
}
