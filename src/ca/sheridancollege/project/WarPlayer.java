package ca.sheridancollege.project;

public class WarPlayer extends Player {

    //create a field variable of object of GroupOfCards named 'deck'
    private GroupOfCards deck;

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

    @Override
    public void play() {
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }
    
}
