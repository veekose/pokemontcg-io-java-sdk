package io.pokemontcg;

import java.io.IOException;
import java.util.Optional;

/**
 * Implementing the {@code Searchable<T>} interface denotes that the implementer will have the ability to make calls
 * to the Pokemon TCG API via the base URL: {@literal https://api.pokemontcg.io/<version>/<resource>}
 * @param <T> The type of {@link io.pokemontcg.model} to be stored in the {@code List}
 */
interface Searchable<T> {
    Optional<T> all() throws IOException;
}
