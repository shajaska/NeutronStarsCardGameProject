package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class WarPlayer extends Player {

    //create a field variable of object of GroupOfCards named 'deck'
    private GroupOfCards deck;
    private ArrayList<Card> hands;

    //a method to set the hands

    //getDeck
    public GroupOfCards getDeck() {
        return deck;
    }

    //setter method for deck
    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }

    public WarPlayer(String name) {
        super(name);
    }

    public Card drawTopCard() {
    if (hands.size() == 0) {
        return null;
    }
    return hands.remove(0);
    }

    public void collectCard(Card... wonCards) {
        Collections.addAll(this.hands, wonCards);
    }


    @Override
    public void play() {
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
    
}
