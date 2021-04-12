package org.dmonix.area51;

import org.dmonix.area51.data.CharacterStorage;
import org.dmonix.area51.data.InMemoryCharacterStorage;
import org.dmonix.area51.model.Character;
import org.dmonix.area51.model.Planet;
import org.dmonix.area51.model.Species;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
  /**
   * Prep the in-memory/fake character storage
   *
   * @return
   */
  @Bean
  public CharacterStorage characterStorage() {
    Planet tatooine = new Planet("Tatooine", "desert");
    Planet kashyyyk = new Planet("Kashyyyk", "jungle");
    Planet corellia = new Planet("Corellia", "temperate");
    Species human = new Species("human", 80, new Planet("Earth", "temperate"));
    Species wookie = new Species("wookie", 200, kashyyyk);

    Character luke = new Character("Luke Skywalker", tatooine, human);
    Character kenobi = new Character("Obi-Wan Kenobi", tatooine, human);
    Character han = new Character("Han Solo", corellia, human);
    Character chewie = new Character("Chewbacka", kashyyyk, wookie);

    luke.addFiends(kenobi, han, chewie);
    han.addFiends(luke, chewie);
    chewie.addFiends(luke, chewie);
    kenobi.addFiends(luke);

    InMemoryCharacterStorage storage = new InMemoryCharacterStorage();

    storage.addCharacter(luke);
    storage.addCharacter(han);
    storage.addCharacter(kenobi);
    storage.addCharacter(han);
    return storage;
  }

  /**
   * Create the graphql endpoint
   *
   * @param storage
   * @return
   */
  @Bean
  public Query query(CharacterStorage storage) {
    return new Query(storage);
  }
}
