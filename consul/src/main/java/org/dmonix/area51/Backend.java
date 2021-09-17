package org.dmonix.area51;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("backend")
public class Backend {
  @GetMapping("/backend")
  public String rest() {
    return "Hello from the backend";
  }
}
