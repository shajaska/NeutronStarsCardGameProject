package ca.sheridancollege.project;

import java.util.Scanner;

public class WarGame extends Game {

    private GroupOfCards deck;

   
    public WarGame(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    
    //this method will start the game
    public void startGame() {
        createPlayers();
        deck = new GroupOfCards(52);
        deck.createDeck();

    }
    
    @Override
    public void play() {
       startGame();

    }

    @Override
    public void declareWinner() {
       
    }

    public void displayStats() {

    }

    public void startBattle() {

    }

    public void startWar() {

    }

    public void createPlayers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter player 1 name: ");
        String name1 = input.nextLine();
        System.out.println("Enter player 2 (Computer's) name: ");
        String name2 = input.nextLine();
        Player player1 = new WarPlayer(name1);
        Player player2 = new WarPlayer(name2);
        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());

    }

    public GroupOfCards getDeck() {
        return deck;
    }


    public void setDeck(GroupOfCards deck) {
        this.deck = deck;
    }
    
}

