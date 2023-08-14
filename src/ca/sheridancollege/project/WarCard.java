package ca.sheridancollege.project;

public class WarCard extends Card {
    //two private variables for suit and value
    private Value value;
    private Suit suit;

    //Constructor
    public WarCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    //Enumaration for Value of cards
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    };

    //Enumaration for Suit of cards
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };

    public String toString(){
        return "temp";
    }
}
