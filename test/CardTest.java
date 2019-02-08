import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    public void testCardConstructorThrowsExceptionIfSuitNotValid() {
        assertThrows(IllegalArgumentException.class, () -> new Card("l4"));
    }

    @Test
    public void testCardConstructorThrowsExceptionIfRankNotValid() {
        assertThrows(IllegalArgumentException.class, () -> new Card("s1"));
        assertThrows(IllegalArgumentException.class, () -> new Card("si"));
    }

    @Test
    public void testCardConstructorWorksIfRankIsNumber() {
        Card card = new Card("h2");
        assertEquals("h2", card.cardCode);
    }

    @Test
    public void testCardConstructorWorksIfRankIsCharacter() {
        Card card = new Card("hq");
        assertEquals("hq", card.cardCode);
    }

    @Test
    public void testGetValueOfCardIfRankIsNumber() {
        Card card = new Card("h2");
        assertEquals(2, card.getValue());
    }

    @Test
    public void testGetValueOfCardIfRankIsCharacter() {
        Card card = new Card("ha");
        assertEquals(14, card.getValue());
    }
}