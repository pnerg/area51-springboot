package org.dmonix.area51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("frontend")
@RequestMapping("/frontend")
public class Frontend {

  private final RestTemplate restTemplate;
  private final DiscoveryClient discoveryClient;

  @Autowired
  Frontend(RestTemplate restTemplate, DiscoveryClient discoveryClient) {
    System.out.println("------------ Started Frontend");
    this.restTemplate = restTemplate;
    this.discoveryClient = discoveryClient;
  }

  @GetMapping("/manual")
  public String manualLookup() {
    discoveryClient.getInstances("consul-test-app").forEach(s -> System.out.println(s));
    return "";
  }

  @GetMapping("/automatic")
  public String automaticLookup() {
    return restTemplate.getForObject("http://consul-test-app/backend", String.class);
  }
}
