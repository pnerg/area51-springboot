package org.dmonix.area51.data;

import org.dmonix.area51.model.Character;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryCharacterStorage implements CharacterStorage {
  private final Map<String, Character> heroes = new HashMap<>();

  @Override
  public Collection<Character> getCharacters() {
    return heroes.values();
  }

  @Override
  public Character getCharacter(String name) {
    return heroes.get(name);
  }

  public void addCharacter(Character character) {
    heroes.put(character.name, character);
  }
}
