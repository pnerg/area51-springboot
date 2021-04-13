package org.dmonix.area51;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.dmonix.area51.data.CharacterStorage;
import org.dmonix.area51.model.Character;

import java.util.Collection;

/** Manages the graphql queries */
public class Query implements GraphQLQueryResolver {

  private final CharacterStorage storage;

  public Query(CharacterStorage storage) {
    this.storage = storage;
  }

  /** The realisation of the 'hero(name:String): Character' query */
  public Character hero(String name) {
    return storage.getCharacter(name);
  }

  /** The realisation of the 'heroes: [Character]' query */
  public Collection<Character> heroes() {
    return storage.getCharacters();
  }
}
