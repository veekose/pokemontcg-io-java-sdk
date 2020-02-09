package io.pokemontcg.model;

import java.util.List;

public class SuperTypes extends AbstractModel {
    List<SuperType> supertypes;

    public List<SuperType> getSupertypes() { return supertypes; }
    public void setSupertypes(List<SuperType> supertypes) { this.supertypes = supertypes; }
}
