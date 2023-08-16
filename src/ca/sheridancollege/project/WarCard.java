package ca.sheridancollege.project;

/**
 * This class models a card in a standard deck of 52 playing cards.
 * It is a subclass of the Card class.
 * It contains two enums, one for the value of the card and one for the suit.
 * It also contains a toString method that returns the value and suit of the card.
 * */

public class WarCard extends Card {
    
    private Value value;
    private Suit suit;

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public WarCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    };

    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }

}
