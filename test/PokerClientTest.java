import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerClientTest {

    private PokerClient pokerClient = new PokerClient("s2", "h4", "hq", "c10", "ha");

    @Test
    public void testHighestCardIsMineFalse() {
        assertFalse(pokerClient.highestCardIsMine("d3", "ca", "hk", "dq", "d9"));
    }

    @Test
    public void testHighestCardIsMineTrue() {
        assertTrue(pokerClient.highestCardIsMine("d3", "ck", "hk", "dq", "d9"));
    }
}