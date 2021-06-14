package org.dmonix.area51.config;

import org.dmonix.area51.components.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
public class AlternativeStorageConfig {
  @Bean
  public Storage getAlternativeStorage() {
    return new AlternativeStorage();
  }

  private static class AlternativeStorage implements Storage {
    private final Map<String, String> map = new HashMap<>();

    @Override
    public void store(String id, String value) {
      map.put(id, value);
    }

    @Override
    public Optional<String> read(String id) {
      return Optional.ofNullable(map.get(id));
    }
  }
}
