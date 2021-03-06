package org.dmonix.area51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * Entry point for the app.
 *
 * <p>The Import/EnableAutoConfiguration are needed for the app to bootstrap itself properly
 */
@SpringBootApplication
@Import(GraphqlConfiguration.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}
