package com.lnicho.owmyaws.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lnicho.owmyaws.model.User;
import com.lnicho.owmyaws.service.UserService;
import com.lnicho.owmyaws.service.exception.NotFoundException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerErrorException;

@Slf4j
@RestController
public class HelloController {

  private final UserService userService;
  private final ObjectMapper objectMapper;

  public HelloController(UserService userService, ObjectMapper objectMapper) {
    this.userService = userService;
    this.objectMapper = objectMapper;
  }

  @GetMapping(path = "/")
  public String GetHello(HttpServletRequest request) {
    log.info("Received request: " + request.getMethod() + " " + request.getRequestURI());

    var response = "Hello from Java!";
    log.info("Returning: " + response);
    return "Hello from Java!";
  }

  @GetMapping(path = "/users/{userId}")
  public ResponseEntity<?> GetUserById(@PathVariable("userId") long userId)
  {
    log.info("Getting user " + userId);
    ResponseEntity<?> response;
    try {
      response = new ResponseEntity<>(userService.GetUserById(userId), HttpStatus.OK);
    } catch (NotFoundException ex)
    {
      response = new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    log.info("Returning: " + response.toString());
    return response;
  }
}
