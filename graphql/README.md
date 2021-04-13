GRAPHQL
====

Provides a simple graphql enabled API.   

# Data model
The data model is defined in [schema.graphqls](src/main/resources/schema.graphqls).   
It has two simple query operations 
* `heroes: [Character]` to list all heroes
* `hero(name:String): Character` to get details on a named hero

# Architecture

The starting point is the main app [Main](src/main/java/org/dmonix/area51/Main.java) which pretty much only bootstraps the app.   
The `SimpleGraphQLApplication`enables the autowiring/configuration using [GraphqlConfiguration](src/main/java/org/dmonix/area51/GraphqlConfiguration.java) creating the following classes:
* [InMemoryCharacterStorage](src/main/java/org/dmonix/area51/InMemoryCharacterStorage.java) implements the `CharacterStorage` interface for fetching characters.  
Fake as it is it just illustrates the concept of fetching data from somewhere
* [Query](src/main/java/org/dmonix/area51/Query.java) is the entry point for all graphql queries. The class implements the operations defined in the [schema.graphqls](src/main/resources/schema.graphqls) schema

# Run
Start the app with `sbt graphql/run`


## Example queries
To test the queries one can just use `curl` but it's recommended to use a visual tool like [graphiql](https://github.com/graphql/graphiql), find it for your platform.
### List all heroes with name

```graphql
{
  heroes{
    name
  }
}
```
would yield:
```json
{
  "data": {
    "heroes": [
      {
        "name": "Chewbacca"
      },
      {
        "name": "Obi-Wan Kenobi"
      },
      {
        "name": "Luke Skywalker"
      },
      {
        "name": "Han Solo"
      }
    ]
  }
}
```
### Some intel on Chewbacca and all his friends:

```graphql
{
  hero(name: "Chewbacca") {
    name
    species {
      name
      lifespan
      origin {
        name
        climate
      }
    }
    friends {
      name
      species {
        name
        lifespan
      }
    }
  }
}
```
Would yield:
```json
{
  "data": {
    "hero": {
      "name": "Chewbacca",
      "species": {
        "name": "wookie",
        "lifespan": 200,
        "origin": {
          "name": "Kashyyyk",
          "climate": "jungle"
        }
      },
      "friends": [
        {
          "name": "Luke Skywalker",
          "species": {
            "name": "human",
            "lifespan": 80
          }
        },
        {
          "name": "Han Solo",
          "species": {
            "name": "human",
            "lifespan": 80
          }
        }
      ]
    }
  }
}
```