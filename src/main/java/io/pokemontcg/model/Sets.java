package io.pokemontcg.model;

import java.util.List;

public class Sets extends AbstractModel {
    List<Set> sets;
    Set set;

    public List<Set> getSets() { return sets; }
    public void setSets(List<Set> sets) { this.sets = sets; }

    public Set getSet() { return set; }
    public void setSet(Set set) { this.set = set; }
}
