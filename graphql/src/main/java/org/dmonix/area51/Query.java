package org.dmonix.area51;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.dmonix.area51.data.CharacterStorage;
import org.dmonix.area51.model.Character;

public class Query implements GraphQLQueryResolver {

  private final CharacterStorage storage;

  public Query(CharacterStorage storage) {
    this.storage = storage;
  }

  /**
   * The realisation of the 'hero(name:String): Character' query
   *
   * @param name
   * @return
   */
  public Character hero(String name) {
    return storage.getCharacter(name);
  }
}
