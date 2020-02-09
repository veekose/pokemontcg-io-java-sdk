import io.pokemontcg.PokemonTcg;
import io.pokemontcg.model.Card;
import io.pokemontcg.model.Cards;

import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        try {
            Optional<Cards> response = PokemonTcg.cards().where("pageSize=300").all();
            if (response.isPresent()) {
                List<Card> cards = response.get().getCards();
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }
}
