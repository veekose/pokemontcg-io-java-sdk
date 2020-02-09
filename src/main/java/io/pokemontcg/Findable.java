package io.pokemontcg;

import java.io.IOException;
import java.util.Optional;

interface Findable<T> {
    Optional<T> find(String id) throws IOException;
}
