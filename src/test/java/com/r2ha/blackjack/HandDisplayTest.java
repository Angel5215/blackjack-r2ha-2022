package com.r2ha.blackjack;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class HandDisplayTest {
    @Test
    void displayFaceUpCardReturnsAsCorrectString() throws Exception {
        List<Card> cards = List.of(
                new Card(Suit.HEARTS, Rank.ACE),
                new Card(Suit.CLUBS, Rank.JACK));
        Hand hand = new Hand(cards);

        assertThat(hand.displayFaceUpCard())
                .isEqualTo("[31m┌─────────┐[1B[11D│A        │[1B[11D│         │[1B[11D│    ♥    │[1B[11D│         │[1B[11D│        A│[1B[11D└─────────┘");
    }
}
