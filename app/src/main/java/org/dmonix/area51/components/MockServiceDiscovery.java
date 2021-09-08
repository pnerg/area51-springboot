package org.dmonix.area51.components;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MockServiceDiscovery implements ServiceDiscovery, InitializingBean {
  @Value("${sd.hostName}")
  private String hostName;

  @Value("${sd.port}")
  private int port;

  @Override
  public ServiceInstance getServiceInstances(String name) {
    return new ServiceInstance() {
      @Override
      public String getName() {
        return name;
      }

      @Override
      public List<String> getEndpoints() {
        return Collections.EMPTY_LIST;
      }
    };
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println(hostName + ":" + port);
  }
}
