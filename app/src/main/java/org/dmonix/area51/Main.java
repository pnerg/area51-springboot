package org.dmonix.area51;

import org.dmonix.area51.components.ServiceDiscovery;
import org.dmonix.area51.components.Storage;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"org.dmonix.area51"})
public class Main implements InitializingBean {
  @Autowired private ServiceDiscovery serviceDiscovery;

  @Autowired(required = false)
  private List<Storage> storages = Collections.EMPTY_LIST;

  @Override
  public void afterPropertiesSet() {
    System.out.println("ServiceDiscovery : " + serviceDiscovery.getClass().getName());
    System.out.println("Storage classes:");
    storages.forEach(s -> System.out.println(s.getClass().getName()));
  }

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
