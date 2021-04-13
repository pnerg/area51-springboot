package org.dmonix.area51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
// @Import(SecurityConfig.class)
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @GetMapping("/secured/hello")
  public String secured(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("secured: Hello %s!", name);
  }
}
