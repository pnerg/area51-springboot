package org.dmonix.area51.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Character {
  public final String name;
  List<Character> friends = new ArrayList<>();
  public final Planet homeWorld;
  public final Species species;

  public Character(String name, Planet homeWorld, Species species) {
    this.name = name;
    this.homeWorld = homeWorld;
    this.species = species;
  }

  public void addFiends(Character... characters) {
    Arrays.stream(characters).forEach(friends::add);
  }
}
