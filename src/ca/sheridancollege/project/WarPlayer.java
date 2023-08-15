package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class WarPlayer extends Player {

    private GroupOfCards hand;

    public GroupOfCards getHand() {
        return hand;
    }

    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    public WarPlayer(String name) {
        super(name);
        this.hand = new GroupOfCards(26); // Initial size, but may grow or shrink during the game.
    }

    public WarCard drawTopCard() {
        if (hand.getAllCards().size() == 0) {
            return null;
        }
        return hand.getAllCards().remove(0);
    }

    public void collectCard(WarCard... wonCards) {
        Collections.addAll(this.hand.getAllCards(), wonCards);
    }

    @Override
    public void play() {
        // This can be expanded upon, but for the basic game, players simply draw and play cards.
    }

}
