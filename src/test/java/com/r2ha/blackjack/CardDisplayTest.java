package com.r2ha.blackjack;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CardDisplayTest {

    private static final Suit DUMMY_SUIT = Suit.HEARTS;
    @Test
    public void displayTenAsString() throws Exception {
        Card card = new Card(DUMMY_SUIT, Rank.TEN);

        assertThat(card.display())
                .isEqualTo("[31m┌─────────┐[1B[11D│10       │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│       10│[1B[11D└─────────┘");
    }

    @Test
    public void displayNonTenAsString() throws Exception {
        Card card = new Card(DUMMY_SUIT, Rank.SEVEN);

        assertThat(card.display())
                .isEqualTo("[31m┌─────────┐[1B[11D│7        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        7│[1B[11D└─────────┘");
    }
}
