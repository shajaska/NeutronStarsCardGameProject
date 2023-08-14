/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.sheridancollege.project.WarCard.Suit;
import ca.sheridancollege.project.WarCard.Value;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * @param cards the cards to set
     */
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    //create deck of cards from WarCard class of the enum values for suits and values and add to Card arraylist
    public void createDeck() {
        cards = new ArrayList<Card>();
        Set<Card> cardSet = new HashSet<Card>();
        for (Suit s : Suit.values()) {
            for (Value v : Value.values()) {
                Card card = new WarCard(v, s);
                if (!cardSet.contains(card)) {
                    cards.add(card);
                    cardSet.add(card);
                }
            }
        }
    }

    //another method to check validity of deck
    public boolean deckValidity() {
        Set<Card> cardSet = new HashSet<Card>();
        for (Card card : cards) {
            if (!cardSet.add(card)) {
                // card already exists in the set, so the deck is invalid
                return false;
            }
            if (((WarCard) card).getSuit() == null ||((WarCard) card).getValue() == null) {
                // card has an invalid suit or rank, so the deck is invalid
                return false;
            }
        }
        return true;
    }
    
    

}//end class
