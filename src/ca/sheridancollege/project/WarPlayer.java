package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class WarPlayer extends Player {

    //create a field variable of object of GroupOfCards named 'hand'
    private GroupOfCards hand;

    //gethand
    public GroupOfCards gethand() {
        return hand;
    }

    //setter method for hand
    public void sethand(GroupOfCards hand) {
        this.hand = hand;
    }

    public WarPlayer(String name) {
        super(name);
    }

    // public Card drawTopCard() {
    // if (hands.size() == 0) {
    //     return null;
    // }
    // return hands.remove(0);
    // }

    // public void collectCard(Card... wonCards) {
    //     Collections.addAll(this.hands, wonCards);
    // }


    @Override
    public void play() {
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
    
}
