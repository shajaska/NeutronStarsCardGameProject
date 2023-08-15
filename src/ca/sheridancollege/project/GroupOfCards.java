package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {

    private ArrayList<WarCard> allCards;
    private int size;

    public GroupOfCards(int size) {
        this.size = size;
        allCards = new ArrayList<>(size);
    }

    public ArrayList<WarCard> getAllCards() {
        return allCards;
    }

    public void shuffle() {
        Collections.shuffle(allCards);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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
