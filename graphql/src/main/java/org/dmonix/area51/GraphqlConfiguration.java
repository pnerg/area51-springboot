package org.dmonix.area51;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
  @Bean
  public Query query() {
    return new Query();
  }
}
