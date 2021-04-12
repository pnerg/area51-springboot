package org.dmonix.area51.data;

import org.dmonix.area51.model.Character;

import java.util.Collection;

public interface CharacterStorage {
  Collection<Character> getCharacters();

  Character getCharacter(String name);
}
