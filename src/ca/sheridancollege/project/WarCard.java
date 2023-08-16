package ca.sheridancollege.project;

/**
 * This class models a card in a standard deck of 52 playing cards.
 * It is a subclass of the Card class.
 * It contains two enums, one for the value of the card and one for the suit.
 * It also contains a toString method that returns the value and suit of the card.
 * */

public class WarCard extends Card {

    /**
     * The value of the card
     * and the suit of the card
     */
    private Value value;
    private Suit suit;

    /**
     *Returns the value of the card.
     * @return the value of the card 
     */
    public Value getValue() {
        return value;
    }

    /**
     * Sets the value of the card.
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * returns the suit of the card.
     * @return
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Sets the suit of the card.
     * @param suit
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    /**
     * Constructor for the WarCard class.
     * @param value
     * @param suit
     */
    public WarCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    /**
     * This enum contains the values of the cards.
     */
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    };

    /**
     * This enum contains the suits of the cards.
     */
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    /**
     * This method returns the value and suit of the card.
     */
    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }

}
