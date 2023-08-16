package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The GroupOfCards class represents a group of cards in a card game.
 * It contains methods for shuffling the cards, getting the size of the group, and creating a new deck of cards.
 */
public class GroupOfCards {

    private ArrayList<WarCard> allCards;
    private int size;

    /**
     * Constructs a new GroupOfCards object with the given size.
     *
     * @param size the size of the group of cards
     */
    public GroupOfCards(int size) {
        this.size = size;
        allCards = new ArrayList<>(size);
    }

    /**
     * Returns the list of all cards in the group.
     *
     * @return the list of all cards in the group
     */
    public ArrayList<WarCard> getAllCards() {
        return allCards;
    }

    /**
     * Shuffles the cards in the group.
     */
    public void shuffle() {
        Collections.shuffle(allCards);
    }

    /**
     * Returns the size of the group of cards.
     *
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the group of cards.
     *
     * @param size the new size of the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Creates a new deck of cards and adds them to the group.
     * The deck contains one card of each suit and value.
     */
    public void createDeck() {
        allCards.clear();
        for (WarCard.Suit s : WarCard.Suit.values()) {
            for (WarCard.Value v : WarCard.Value.values()) {
                WarCard card = new WarCard(v, s);
                allCards.add(card);               
            }
        }
    }

}