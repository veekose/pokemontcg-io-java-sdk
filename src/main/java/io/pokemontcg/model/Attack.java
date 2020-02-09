package io.pokemontcg.model;

import java.util.List;

public class Attack {
    private List<Type> cost;
    private String name;
    private String text;
    private String damage;
    private Integer convertedEnergyCost;

    public List<Type> getCost() { return cost; }
    public void setCost(List<Type> cost) { this.cost = cost; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getDamage() { return damage; }
    public void setDamage(String damage) { this.damage = damage; }

    public Integer getConvertedEnergyCost() { return convertedEnergyCost; }
    public void setConvertedEnergyCost(Integer convertedEnergyCost) { this.convertedEnergyCost = convertedEnergyCost; }
}
