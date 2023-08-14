package ca.sheridancollege.project;

public class WarCard extends Card {
    //two private variables for suit and value
    private Value value;
    private Suit suit;

    //getter for value
    public Value getValue() {
        return value;
    }

    //setter for value
    public void setValue(Value value) {
        this.value = value;
    }

    //getter for suit
    public Suit getSuit() {
        return suit;
    }

    //setter for suit
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    //Constructor
    public WarCard(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    //create card
    public WarCard createCard(){
        return new WarCard(value, suit);
    }


    //Enumaration for Value of cards
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    };

    //Enumaration for Suit of cards
    public enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };


    @Override
    public String toString() {
        return this.value + " of " + this.suit;
    }

}
