package io.pokemontcg.model;

import java.util.List;

public class SubTypes extends AbstractModel {
    List<SubType> subtypes;

    public List<SubType> getSubtypes() { return subtypes; }
    public void setSubtypes(List<SubType> subtypes) { this.subtypes = subtypes; }
}
