import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerClient {

    List<Card> cards;

    public PokerClient(String card1, String card2, String card3, String card4, String card5) {
        cards = getCardList(card1, card2, card3, card4, card5);
    }

    public boolean highestCardIsMine(String otherCard1, String otherCard2, String otherCard3, String otherCard4, String otherCard5) {
        List<Card> otherCards = getCardList(otherCard1, otherCard2, otherCard3, otherCard4, otherCard5);

        int highestOwnCard = getHighestValueFromCardList(cards);
        int highestOtherCard = getHighestValueFromCardList(otherCards);

        return highestOwnCard > highestOtherCard;
    }

    private int getHighestValueFromCardList(List<Card> cards) {
        return cards.stream()
                .mapToInt(Card::getValue)
                .max()
                .getAsInt();
    }

    private List<Card> getCardList(String card1, String card2, String card3, String card4, String card5) {
        return Stream.of(card1, card2, card3, card4, card5)
                .map(Card::new)
                .collect(Collectors.toList());
    }

}