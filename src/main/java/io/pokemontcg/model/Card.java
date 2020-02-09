package io.pokemontcg.model;

import java.util.List;

public class Card {
    private String id;
    private String name;
    private int nationalPokedexNumber;
    private String imageUrl;
    private String imageUrlHiRes;
    private List<Type> types;
    private SuperType superType;
    private SubType subType;
    private String evolvesFrom;
    private Ability ability;
    private Ability ancientTrait;
    private String hp;
    private List<Type> retreatCost;
    private int convertedRetreatCost;
    private String number;
    private String artist;
    private String rarity;
    private String series;
    private String set;
    private String setCode;
    private List<String> text;
    private List<Attack> attacks;
    private List<Effect> resistances;
    private List<Effect> weaknesses;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getNationalPokedexNumber() { return nationalPokedexNumber; }
    public void setNationalPokedexNumber(int nationalPokedexNumber) { this.nationalPokedexNumber = nationalPokedexNumber; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getImageUrlHiRes() { return imageUrlHiRes; }
    public void setImageUrlHiRes(String imageUrlHiRes) { this.imageUrlHiRes = imageUrlHiRes; }

    public List<Type> getTypes() { return types; }
    public void setTypes(List<Type> types) { this.types = types; }

    public SuperType getSuperType() { return superType; }
    public void setSuperType(SuperType superType) { this.superType = superType; }

    public SubType getSubType() { return subType; }
    public void setSubType(SubType subType) { this.subType = subType; }

    public String getEvolvesFrom() { return evolvesFrom; }
    public void setEvolvesFrom(String evolvesFrom) { this.evolvesFrom = evolvesFrom; }

    public Ability getAbility() { return ability; }
    public void setAbility(Ability ability) { this.ability = ability; }

    public Ability getAncientTrait() { return ancientTrait; }
    public void setAncientTrait(Ability ancientTrait) { this.ancientTrait = ancientTrait; }

    public String getHp() { return hp; }
    public void setHp(String hp) { this.hp = hp; }

    public List<Type> getRetreatCost() { return retreatCost; }
    public void setRetreatCost(List<Type> retreatCost) { this.retreatCost = retreatCost; }

    public int getConvertedRetreatCost() { return convertedRetreatCost; }
    public void setConvertedRetreatCost(int convertedRetreatCost) { this.convertedRetreatCost = convertedRetreatCost; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getRarity() { return rarity; }
    public void setRarity(String rarity) { this.rarity = rarity; }

    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }

    public String getSet() { return set; }
    public void setSet(String set) { this.set = set; }

    public String getSetCode() { return setCode; }
    public void setSetCode(String setCode) { this.setCode = setCode; }

    public List<String> getText() { return text; }
    public void setText(List<String> text) { this.text = text; }

    public List<Attack> getAttacks() { return attacks; }
    public void setAttacks(List<Attack> attacks) { this.attacks = attacks; }

    public List<Effect> getResistances() { return resistances; }
    public void setResistances(List<Effect> resistances) { this.resistances = resistances; }

    public List<Effect> getWeaknesses() { return weaknesses; }
    public void setWeaknesses(List<Effect> weaknesses) { this.weaknesses = weaknesses; }
}
