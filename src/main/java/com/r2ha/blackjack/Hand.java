package com.r2ha.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Hand() {
    }

    public List<Card> cards() {
        List<Card> cards = new ArrayList<>();
        for (Card card: this.cards) {
            Card copy = new Card(card.suit(), card.rank());
            cards.add(copy);
        }
        return cards;
    }

    public Card dealerFaceUpCard() {
        return cards.get(0);
    }

    private int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    boolean dealerMustDrawCard() {
        return value() <= 16;
    }

    void display() {
        System.out.println(ConsoleHand.cardsAsString(this));
    }

    public void drawFrom(Deck deck) {
        cards.add(deck.draw());
    }

    boolean isBusted() {
        return value() > 21;
    }

    boolean pushes(Hand hand) {
        return hand.value() == value();
    }

    boolean beats(Hand hand) {
        return hand.value() < value();
    }

    String displayValue() {
        return String.valueOf(value());
    }

    public boolean valueEquals(int target) {
        return value() == target;
    }
}
