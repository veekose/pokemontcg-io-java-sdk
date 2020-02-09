package io.pokemontcg.model;

import java.util.List;

public class Cards  extends AbstractModel{
    private List<Card> cards;
    private Card card;

    public List<Card> getCards() { return cards; }
    public void setCards(List<Card> cards) { this.cards = cards; }

    public Card getCard() { return card; }
    public void setCard(Card card) { this.card = card; }
}
