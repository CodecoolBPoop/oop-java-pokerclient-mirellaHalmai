import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {

    String cardCode;
    private String cardSuit;
    private String cardRank;
    private static final List<String> CARD_SUITS = Arrays.asList("S", "C", "D", "H");
    private static final Map<String, Integer> CARD_RANKS = Stream.of(
            new AbstractMap.SimpleImmutableEntry<>("2", 2),
            new AbstractMap.SimpleImmutableEntry<>("3", 3),
            new AbstractMap.SimpleImmutableEntry<>("4", 4),
            new AbstractMap.SimpleImmutableEntry<>("5", 5),
            new AbstractMap.SimpleImmutableEntry<>("6", 6),
            new AbstractMap.SimpleImmutableEntry<>("7", 7),
            new AbstractMap.SimpleImmutableEntry<>("8", 8),
            new AbstractMap.SimpleImmutableEntry<>("9", 9),
            new AbstractMap.SimpleImmutableEntry<>("10", 10),
            new AbstractMap.SimpleImmutableEntry<>("J", 11),
            new AbstractMap.SimpleImmutableEntry<>("Q", 12),
            new AbstractMap.SimpleImmutableEntry<>("K", 13),
            new AbstractMap.SimpleImmutableEntry<>("A", 14))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public Card(String cardCode) throws IllegalArgumentException {

        String cardSuit = cardCode.substring(0, 1).toUpperCase();

        if (!CARD_SUITS.contains(cardSuit)) {
            throw new IllegalArgumentException("card color isn't valid: " + cardSuit);
        }

        String cardRank = cardCode.substring(1).toUpperCase();

        if (!CARD_RANKS.containsKey(cardRank)) {
            throw new IllegalArgumentException("card number isn't valid: " + cardRank);
        }
        this.cardCode = cardCode;
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getValue() {
        return CARD_RANKS.get(cardRank);
    }
}
