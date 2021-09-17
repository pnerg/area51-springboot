package org.dmonix.area51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Main {

  private final DiscoveryClient discoveryClient;

  Main(@Autowired DiscoveryClient discoveryClient) {
    this.discoveryClient = discoveryClient;

    System.out.println(getService("consul-test-app"));
  }

  @LoadBalanced
  @Bean
  public RestTemplate loadbalancedRestTemplate() {
    return new RestTemplate();
  }

  private ServiceInstance getService(String serviceID) {
    List<ServiceInstance> list = discoveryClient.getInstances(serviceID);
    if (list != null && list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
