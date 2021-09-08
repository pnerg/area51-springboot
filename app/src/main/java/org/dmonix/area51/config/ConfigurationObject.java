package org.dmonix.area51.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.time.Duration;

/** Simple POJO that is to be auto-populated from the application.yaml */
@ConfigurationProperties("example-config")
public class ConfigurationObject {

  public final String host;
  public final int port;
  public final Duration interval;

  @ConstructorBinding
  public ConfigurationObject(String host, int port, Duration interval) {
    this.host = host;
    this.port = port;
    this.interval = interval;
  }

  @Override
  public String toString() {
    return "ConfigurationObject{"
        + "host='"
        + host
        + '\''
        + ", port="
        + port
        + ", interval="
        + interval
        + '}';
  }
}
