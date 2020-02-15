import io.pokemontcg.CardSearchParameters;
import io.pokemontcg.PokemonTcg;
import io.pokemontcg.SetSearchParameters;
import io.pokemontcg.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class PokemonTcgTest {

    @Test
    public void testCardsBuilder_all() {
        Optional<Cards> cardsOptional = Optional.empty();
        Cards cards = null;
        List<Card> cardList = null;

        try {
            cardsOptional = PokemonTcg.cards().all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(cardsOptional.isPresent());

        cards = cardsOptional.get();

        Assertions.assertTrue(cards.getTotalCount() > 7000);

        cardList = cards.getCards();

        Assertions.assertNotNull(cardList);
        Assertions.assertTrue(cardList.size() > 0);
    }

    @Test
    public void testCardsBuilder_find() {
        Optional<Cards> cardsOptional = Optional.empty();
        Card card = null;

        try {
            cardsOptional = PokemonTcg.cards().find("ex14-28");
        } catch (IOException ignored) { }

        Assertions.assertTrue(cardsOptional.isPresent());

        card = cardsOptional.get().getCard();

        Assertions.assertNotNull(card);
        Assertions.assertEquals(card.getId(), "ex14-28");
        Assertions.assertEquals(card.getName(), "Venusaur");
        Assertions.assertEquals(card.getNationalPokedexNumber(), 3);
    }

    @Test
    public void testCardsBuilder_where() {
        Optional<Cards> cardsOptional = Optional.empty();
        Cards cards = null;
        List<Card> cardList = null;

        try {
            cardsOptional = PokemonTcg.cards()
                .where(CardSearchParameters.NAME, "Wailord")
                .all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(cardsOptional.isPresent());

        cards = cardsOptional.get();

        Assertions.assertTrue(cards.getTotalCount() > 0);

        cardList = cards.getCards();

        Assertions.assertNotNull(cardList);
        Assertions.assertTrue(cardList.size() > 0);
        Assertions.assertTrue(cardList.stream().allMatch(c -> c != null && c.getName() != null && c.getName().toLowerCase().contains("wailord")));
    }

    @Test
    public void testCardsBuilder_where_null_CardSearchParameter() {
        Assertions.assertThrows(NullPointerException.class, () ->
            PokemonTcg.cards()
                .where(null, "Wailord")
                .all());
    }

    @Test
    public void testCardsBuilder_where_null_search_value() {
        Assertions.assertThrows(NullPointerException.class, () ->
            PokemonTcg.cards()
                .where(CardSearchParameters.NAME, null)
                .all());
    }

    @Test
    public void testSetsBuilder_all() {
        Optional<Sets> setsOptional = Optional.empty();
        Sets sets = null;
        List<Set> setList = null;

        try {
            setsOptional = PokemonTcg.sets().all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(setsOptional.isPresent());

        sets = setsOptional.get();

        Assertions.assertTrue(sets.getTotalCount() > 100);

        setList = sets.getSets();

        Assertions.assertNotNull(setList);
        Assertions.assertTrue(setList.size() > 0);
    }

    @Test
    public void testSetsBuilder_find() {
        Optional<Sets> setsOptional = Optional.empty();
        Set set = null;

        try {
            setsOptional = PokemonTcg.sets().find("base1");
        } catch (IOException ignored) { }

        Assertions.assertTrue(setsOptional.isPresent());

        set = setsOptional.get().getSet();

        Assertions.assertNotNull(set);
        Assertions.assertEquals(set.getName(), "Base");
        Assertions.assertEquals(set.getPtcgoCode(), "BS");
        Assertions.assertEquals(set.getTotalCards(), 102);
    }

    @Test
    public void testSetsBuilder_where() {
        Optional<Sets> setsOptional = Optional.empty();
        Sets sets = null;
        List<Set> setList = null;

        try {
            setsOptional = PokemonTcg.sets()
                .where(SetSearchParameters.STANDARDLEGAL, "true")
                .all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(setsOptional.isPresent());

        sets = setsOptional.get();

        Assertions.assertTrue(sets.getTotalCount() > 0);

        setList = sets.getSets();

        Assertions.assertNotNull(setList);
        Assertions.assertTrue(setList.size() > 0);
        Assertions.assertTrue(setList.stream().allMatch(Set::getStandardLegal));
    }

    @Test
    public void testSetsBuilder_where_null_SetSearchParameter() {
        Assertions.assertThrows(NullPointerException.class, () ->
            PokemonTcg.sets()
                .where(null, "Base")
                .all());
    }

    @Test
    public void testSetsBuilder_where_null_search_value() {
        Assertions.assertThrows(NullPointerException.class, () ->
            PokemonTcg.sets()
                .where(SetSearchParameters.NAME, null)
                .all());
    }

    @Test
    public void testTypesBuilder_all() {
        Optional<Types> typesOptional = Optional.empty();
        List<Type> typeList = null;

        try {
            typesOptional = PokemonTcg.types().all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(typesOptional.isPresent());

        typeList = typesOptional.get().getTypes();

        Assertions.assertNotNull(typeList);
        Assertions.assertTrue(typeList.size() > 0);
    }

    @Test
    public void testSubTypesBuilder_all() {
        Optional<SubTypes> subtypesOptional = Optional.empty();
        List<SubType> subtypeList = null;

        try {
            subtypesOptional = PokemonTcg.subTypes().all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(subtypesOptional.isPresent());

        subtypeList = subtypesOptional.get().getSubtypes();

        Assertions.assertNotNull(subtypeList);
        Assertions.assertTrue(subtypeList.size() > 0);
    }

    @Test
    public void testSuperTypesBuilder_all() {
        Optional<SuperTypes> supertypesOptional = Optional.empty();
        List<SuperType> supertypeList = null;

        try {
            supertypesOptional = PokemonTcg.superTypes().all();
        } catch (IOException ignored) { }

        Assertions.assertTrue(supertypesOptional.isPresent());

        supertypeList = supertypesOptional.get().getSupertypes();

        Assertions.assertNotNull(supertypeList);
        Assertions.assertTrue(supertypeList.size() > 0);
    }
}
