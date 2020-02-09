package io.pokemontcg;

import io.pokemontcg.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * This class acts an entry point into the Pokemon TCG SDK by providing access to static Builder classes corresponding
 * to each of the endpoints of the <a href="https://docs.pokemontcg.io/#documentationgetting_started" target="_blank">
 * Pokemon TCG API</a> (cards, sets, types, subtypes, and supertypes).
 */
public class PokemonTcg {

    /**
     * A factory method that returns a new instance of the {@code CardsBuilder} class
     * @return a new instance of the {@code CardsBuilder} class
     */
    public static CardsBuilder cards() { return new CardsBuilder(); }

    /**
     * A factory method that returns a new instance of the {@code SetsBuilder} class
     * @return a new instance of the {@code SetsBuilder} class
     */
    public static SetsBuilder sets() { return new SetsBuilder(); }

    /**
     * A factory method that returns a new instance of the {@code TypesBuilder} class
     * @return a new instance of the {@code TypesBuilder} class
     */
    public static TypesBuilder types() { return new TypesBuilder(); }

    /**
     * A factory method that returns a new instance of the {@code SubTypesBuilder} class
     * @return a new instance of the {@code SubTypesBuilder} class
     */
    public static SubTypesBuilder subTypes() { return new SubTypesBuilder(); }

    /**
     * A factory method that returns a new instance of the {@code SuperTypesBuilder} class
     * @return a new instance of the {@code SuperTypesBuilder} class
     */
    public static SuperTypesBuilder superTypes() { return new SuperTypesBuilder(); }

    /**
     * Builder class for making REST calls to the <a href="https://docs.pokemontcg.io/#api_v1cards_list" target="_blank">/cards</a>
     * Pokemon TCG API endpoint.
     */
    public static class CardsBuilder extends AbstractBuilder implements Searchable<Cards>, Filterable<CardSearchParameters>, Findable<Cards> {

        @Override
        public Optional<Cards> all() throws IOException {
            return Optional.ofNullable(findAll());

        }

        @Override
        public Optional<Cards> find(String id) throws IOException {
            Objects.requireNonNull(id);
            return Optional.ofNullable(findById(id));
        }

        @Override
        public CardsBuilder where(CardSearchParameters parameter, String value) {
            Objects.requireNonNull(parameter);
            Objects.requireNonNull(value);
            getQueryParameters().put(parameter.toString(), value);
            return this;
        }

        @Override
        public CardsBuilder where(String value) {
            Objects.requireNonNull(value);
            getQueryParameters().put("", value);
            return this;
        }

        @Override
        public void clearSearchParameters() {
            getQueryParameters().clear();
        }

        @Override
        protected String getEndpointName() { return "cards"; }

        @Override
        protected Class getMappingClass() { return Cards.class; }
    }

    /**
     * Builder class for making REST calls to the <a href="https://docs.pokemontcg.io/#api_v1sets_list" target="_blank">/sets</a>
     * Pokemon TCG API endpoint.
     */
    public static class SetsBuilder extends AbstractBuilder implements Searchable<Sets>, Filterable<SetSearchParameters>, Findable<Sets> {

        @Override
        public Optional<Sets> all() throws IOException {
            return Optional.ofNullable(findAll());
        }

        @Override
        public Optional<Sets> find(String id) throws IOException {
            Objects.requireNonNull(id);
            return Optional.ofNullable(findById(id));
        }

        @Override
        public SetsBuilder where(SetSearchParameters parameter, String value) {
            Objects.requireNonNull(parameter);
            Objects.requireNonNull(value);
            getQueryParameters().put(parameter.toString(), value);
            return this;
        }

        @Override
        public SetsBuilder where(String value) {
            Objects.requireNonNull(value);
            getQueryParameters().put("", value);
            return this;
        }

        @Override
        public void clearSearchParameters() {
            getQueryParameters().clear();
        }

        @Override
        protected String getEndpointName() { return "sets"; }

        @Override
        protected Class getMappingClass() { return Sets.class; }
    }

    /**
     * Builder class for making REST calls to the <a href="https://docs.pokemontcg.io/#api_v1types_list" target="_blank">/types</a>
     * Pokemon TCG API endpoint.
     */
    public static class TypesBuilder extends AbstractBuilder implements Searchable<Types> {

        @Override
        public Optional<Types> all() throws IOException {
            return Optional.ofNullable(findAll());
        }

        @Override
        protected String getEndpointName() { return "types"; }

        @Override
        protected Class getMappingClass() { return Types.class; }
    }

    /**
     * Builder class for making REST calls to the <a href="https://docs.pokemontcg.io/#api_v1subtypes_list" target="_blank">/subtypes</a>
     * Pokemon TCG API endpoint.
     */
    public static class SubTypesBuilder extends AbstractBuilder implements Searchable<SubTypes> {

        @Override
        public Optional<SubTypes> all() throws IOException {
            return Optional.ofNullable(findAll());
        }

        @Override
        protected String getEndpointName() { return "subtypes"; }

        @Override
        protected Class getMappingClass() { return SubTypes.class; }
    }

    /**
     * Builder class for making REST calls to the <a href="https://docs.pokemontcg.io/#api_v1supertypes_list" target="_blank">/supertypes</a>
     * Pokemon TCG API endpoint.
     */
    public static class SuperTypesBuilder extends AbstractBuilder implements Searchable<SuperTypes> {

        @Override
        public Optional<SuperTypes> all() throws IOException {
            return Optional.ofNullable(findAll());
        }

        @Override
        protected String getEndpointName() { return "supertypes"; }

        @Override
        protected Class getMappingClass() { return SuperTypes.class; }
    }
}