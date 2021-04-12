package org.dmonix.area51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GraphqlConfiguration.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class SimpleGraphQLApplication {

  public static void main(String[] args) {
    SpringApplication.run(SimpleGraphQLApplication.class, args);
  }
}
