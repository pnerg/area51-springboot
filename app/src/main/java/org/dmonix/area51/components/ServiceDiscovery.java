package org.dmonix.area51.components;

import java.util.List;

public interface ServiceDiscovery {
  interface ServiceInstance {
    String getName();

    List<String> getEndpoints();
  }

  ServiceInstance getServiceInstances(String name);
}
