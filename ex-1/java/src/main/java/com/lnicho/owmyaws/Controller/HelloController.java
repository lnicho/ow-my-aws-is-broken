package com.lnicho.owmyaws.Controller;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

  @GetMapping(path = "/")
  public String GetHello(HttpServletRequest request) {
    log.info("Received request: " + request.getMethod() + " " + request.getRequestURI());

    var response = "Hello from Java!";
    log.info("Returning: " + response);
    return "Hello from Java!";
  }
}
