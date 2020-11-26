package com.lnicho.owmyaws.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping(path = "/")
  public String GetHello() {
    return "Hello from Java!";
  }
}
