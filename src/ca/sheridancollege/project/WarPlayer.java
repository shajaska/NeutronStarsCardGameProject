package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The WarPlayer class represents a player in the game of War.
 * Each player has a hand of cards, which can be drawn from and added to during the game.
 * @author Kirandeep Kaur
 * @modifier Divya Luther, Manjinder Singh, Jaskaran Sharma Punj
 */
public class WarPlayer extends Player {

    private GroupOfCards hand;

    /**
     * Returns the player's hand of cards.
     *
     * @return the player's hand of cards
     */
    public GroupOfCards getHand() {
        return hand;
    }

    /**
     * Sets the player's hand of cards.
     *
     * @param hand the player's hand of cards
     */
    public void setHand(GroupOfCards hand) {
        this.hand = hand;
    }

    /**
     * Constructs a new WarPlayer object with the given name and an empty hand of cards.
     *
     * @param name the name of the player
     */
    public WarPlayer(String name) {
        super(name);
        this.hand = new GroupOfCards(26); // Initial size, but may grow or shrink during the game.
    }

    /**
     * Draws the top card from the player's hand of cards.
     *
     * @return the top card from the player's hand, or null if the hand is empty
     */
    public WarCard drawTopCard() {
        if (hand.getAllCards().size() == 0) {
            return null;
        }
        return hand.getAllCards().remove(0);
    }

    /**
     * Adds the given cards to the player's hand of cards.
     *
     * @param wonCards the cards to be added to the player's hand
     */
    public void collectCard(WarCard... wonCards) {
        Collections.addAll(this.hand.getAllCards(), wonCards);
    }

    /**
     * Plays a card from the player's hand of cards.
     * In the game of War, this simply involves drawing the top card from the player's hand.
     *
     * @return the top card from the player's hand, or null if the hand is empty
     */
    @Override
    public WarCard play() {
        return drawTopCard();
    }

}