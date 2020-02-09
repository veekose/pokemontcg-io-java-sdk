package io.pokemontcg.model;

import java.util.List;

public class Types extends AbstractModel {
    List<Type> types;

    public List<Type> getTypes() { return types; }
    public void setTypes(List<Type> types) { this.types = types; }
}
