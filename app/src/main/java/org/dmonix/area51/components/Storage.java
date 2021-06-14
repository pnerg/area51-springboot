package org.dmonix.area51.components;

import java.util.Optional;

public interface Storage {
  void store(String id, String value);

  Optional<String> read(String id);
}
