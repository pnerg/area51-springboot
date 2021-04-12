package org.dmonix.area51.model;

public class Species {
  private String name;
  private int lifespan;
  private Planet origin;

  public Species(String name, int lifespan, Planet origin) {
    this.name = name;
    this.lifespan = lifespan;
    this.origin = origin;
  }
}
