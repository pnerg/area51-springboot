package org.dmonix.area51;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.dmonix.area51.model.Character;
import org.dmonix.area51.model.Planet;
import org.dmonix.area51.model.Species;

import java.util.HashMap;
import java.util.Map;

public class Query implements GraphQLQueryResolver {

  private final Map<String, Character> heroes = new HashMap<>();

  public Query() {
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

    addCharacter(luke);
    addCharacter(han);
    addCharacter(kenobi);
    addCharacter(han);
  }

  private void addCharacter(Character character) {
    heroes.put(character.name, character);
  }

  public Character hero(String name) {
    return heroes.get(name);
  }
}
