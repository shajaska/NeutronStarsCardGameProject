package ca.sheridancollege.project;

import java.util.Scanner;

public class WarGame extends Game {

    private GroupOfCards deck;
    private WarPlayer player1;
    private WarPlayer player2;

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        startGame();

        while (!gameOver()) {
            startBattle();
        }

        declareWinner();
    }

    private boolean gameOver() {
        return player1.getHand().getAllCards().isEmpty() || player2.getHand().getAllCards().isEmpty();
    }

    @Override
    public void declareWinner() {
        if (player1.getHand().getAllCards().size() > player2.getHand().getAllCards().size()) {
            System.out.println(player1.getName() + " wins!");
        } else {
            System.out.println(player2.getName() + " wins!");
        }
    }

    public void startBattle() {
        WarCard card1 = player1.drawTopCard();
        WarCard card2 = player2.drawTopCard();

        System.out.println(player1.getName() + " draws: " + card1);
        System.out.println(player2.getName() + " draws: " + card2);

        int comparison = card1.getValue().compareTo(card2.getValue());
        if (comparison > 0) {
            player1.collectCard(card1, card2);
            System.out.println(player1.getName() + " wins this round.");
        } else if (comparison < 0) {
            player2.collectCard(card1, card2);
            System.out.println(player2.getName() + " wins this round.");
        } else {
            startWar();
        }
    }

    public void startWar() {
        System.out.println("It's a war!");
    
        if (player1.getHand().getAllCards().size() < 4 || player2.getHand().getAllCards().size() < 4) {
            System.out.println("One of the players doesn't have enough cards for a war! Ending the game...");
            return;
        }
    
        // Each player places 3 cards face-down
        WarCard[] warCardsP1 = new WarCard[4];
        WarCard[] warCardsP2 = new WarCard[4];
        for (int i = 0; i < 3; i++) {
            warCardsP1[i] = player1.drawTopCard();
            warCardsP2[i] = player2.drawTopCard();
        }
        
        // And then one card face-up
        warCardsP1[3] = player1.drawTopCard();
        warCardsP2[3] = player2.drawTopCard();
    
        System.out.println(player1.getName() + " reveals: " + warCardsP1[3]);
        System.out.println(player2.getName() + " reveals: " + warCardsP2[3]);
    
        int comparison = warCardsP1[3].getValue().compareTo(warCardsP2[3].getValue());
        if (comparison > 0) {
            for (WarCard card : warCardsP1) player1.collectCard(card);
            for (WarCard card : warCardsP2) player1.collectCard(card);
            System.out.println(player1.getName() + " wins the war!");
        } else if (comparison < 0) {
            for (WarCard card : warCardsP1) player2.collectCard(card);
            for (WarCard card : warCardsP2) player2.collectCard(card);
            System.out.println(player2.getName() + " wins the war!");
        } else {
            System.out.println("The war continues!");
            startWar(); // If it's a tie again, continue the war
            
        }
    }
    

    public void startGame() {
        createPlayers();
        deck = new GroupOfCards(52);
        deck.createDeck();
        deck.shuffle();

        distributeCards();
    }

    public void distributeCards() {
        while (!deck.getAllCards().isEmpty()) {
            player1.collectCard(deck.getAllCards().remove(0));
            player2.collectCard(deck.getAllCards().remove(0));
        }
    }

    public void createPlayers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter player 1 name: ");
        String name1 = input.nextLine();
        player1 = new WarPlayer(name1);

        System.out.println("Enter player 2 (Computer's) name: ");
        String name2 = input.nextLine();
        player2 = new WarPlayer(name2);

        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());
    }
}
