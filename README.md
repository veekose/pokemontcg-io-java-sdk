# Pokémon TCG Java SDK

This is the Pokémon TCG SDK Java implementation. It is a wrapper around the Pokémon TCG API of [pokemontcg.io](http://pokemontcg.io)

## Usage

### Cards:
  
```java
Optional<Cards> cards = PokemonTcg.cards().all();

cards.get().getCards();

//Calling the all() method will execute the api request
```

#####Query Support

You can and query filters via two different where() methods:
* Use the CardSearchParameter enum
    * where(CardSearchParameter.PARAMETER_NAME, "filterValue")
* Manually build your own query string
    * where("parameter1=value&parameter2=value")

```java
Optional<Cards> cards = PokemonTcg.cards()
    .where(CardSearchParameters.TYPES, "water")
    .where("rarity=rare")
    .all();

cards.get().getCards();

//URL built - https://api.pokemontcg.io/v1/cards?types=water&rarity=rare
```

#####Find a single card by id:

```java
Optional<Cards> card = PokemonTcg.cards().find("xy7-54");

card.get().getCard();

//Calling the find() method will execute the api request
```

### Sets:

```java
Optional<Sets> sets = PokemonTcg.sets().all();

sets.get().getSets();

//Calling the all() method will execute the api request
```

#####Query Support

You can and query filters via two different where() methods:
* Use the CardSearchParameter enum
    * where(CardSearchParameter.PARAMETER_NAME, "filterValue")
* Manually build your own query string
    * where("parameter1=value&parameter2=value")

```java
Optional<Sets> sets = PokemonTcg.sets()
    where(SetSearchParameters.NAME, "Cosmic Eclipse")
    .all();

//URL built - https://api.pokemontcg.io/v1/sets?name=Cosmic%20Eclipse

Optional<List<Set>> sets = PokemonTcg.sets()
    where("standardLegal=false")
    .all();

//URL built - https://api.pokemontcg.io/v1/sets?standardLegal=false
```

#####Find a single set by code

```java
Optional<Sets> set = PokemonTcg.sets().find("xy1")

set.get().getSet();
```

### Types:
Get a list of the available Pokémon card types
* Types - Fire, Water, Electric, etc.
* SubTypes - Basic, Stage 1, Item, Supporter, etc.
* SuperTypes - Pokémon, Trainer, Energy

```java
Optional<Types> types = PokemonTcg.types().all();
types.get().getTypes();

Optional<SubTypes> subTypes = PokemonTcg.subTypes().all();
subTypes.get().getSubTypes();

Optional<SuperTypes> superTypes = PokemonTcg.superTypes().all();
superTypes.get().getSuperTypes();

//Calling the all() method will execute the api request
```

###Additional Query Capabilities
There is a set of operators you can use to make your queries broader
* gt, gte, lt, lte --- greater than, greater than or equal to, less than, less than or equal to
* | and , --- or, and (Can only be used on fields that accept multiple values)

```java
Optional<Cards> cards = PokemonTcg.cards()
    .where(CardSearchParameters.HP, "gt200")
    .all();

//URL built - https://api.pokemontcg.io/v1/cards?hp=gt200

Optional<Cards> cards = PokemonTcg.cards()
    .where(CardSearchParameters.TYPES, "water|fire|dragon")
    .all();

//URL built - https://api.pokemontcg.io/v1/cards?types=water|fire|dragon
```

###Header Information
There are values in the response headers that can be retrieved (if available) via accessors in each response object.

* **Count**: The number of elements returned
* **Total-Count**: The total number of elements (across all pages)
* **Link**: Link headers with prev, last, next, first links (when appropriate)
* **Page-Size**: The page size for the request
* **Ratelimit-Limit**: The ratelimit for a given user
* **Ratelimit-Remaining**: The number of requests left before the ratelimit is exceeded.

```java
Optional<Cards> cards = PokemonTcg.cards().all();

cards.getCount();
cards.getTotalCount();
cards.getLinks();
cards.getPageSize();
cards.getRateLimit();
cards.getRateLimitRemaining();
```

You can use the page and pageSize values as query parameters for your paginated request calls:

```java
Optional<Cards> cards = PokemonTcg.cards()
    .where(CardSearchParameters.PAGE, "3")
    .where(CardSearchParameters.PAGE_SIZE, "50")
    .all();

//URL built - https://api.pokemontcg.io/v1/cards?page=3&pageSize=50
```

###Important Notes

* A minimum Java version of 8 is required to use this SDK.
* The find("id"), where(enum, "value"), and where("value") functions all implement null validations on their parameters using Objects.requireNonNull(). A NullPointerError will be thrown if validation fails.
* Moshi and OkHttp are being used for the JSON to data mapper and REST client library, respectively. If there is a failure from either the request call or the mapper method, an IOException will be thrown by those libraries.
* Basic logging has been setup to show the final URL before the REST call, the JSON returned from the REST call, and any IOExceptions as mentioned above.  