package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The WarGame class represents a game of War.
 * It extends the Game class and overrides the play() and declareWinner() methods.
 * It contains methods for starting the game, distributing cards, creating players, and starting a battle or war.
 * It also contains utility methods for prompting the user to continue, displaying card counts, and checking if the game is over.
 * @author Jaskaran Sharma Punj
 * @modifier Manjinder Singh, Divya Luther, Kirandeep Kaur
 */
public class WarGame extends Game {

    private GroupOfCards deck;
    private WarPlayer player1;
    private WarPlayer player2;

    // utilities
    private Scanner input;
    private int MAX_ROUNDS; 
    private int currentRound = 0;

    /**
     * Constructs a new WarGame object with the given name.
     * Initializes the input scanner and sets the maximum number of rounds.
     * @param name the name of the game
     */
    public WarGame(String name) {
        super(name);
        input = new Scanner(System.in);
        setMaxRounds();
    }

    /**
     * Prompts the user to enter the maximum number of rounds for the game.
     * Validates the input and sets the MAX_ROUNDS variable.
     */
    private void setMaxRounds() {
        System.out.println("Enter the number of rounds you want to play: ");
        try {
            MAX_ROUNDS = Integer.parseInt(input.nextLine().trim());
            if (MAX_ROUNDS <= 0) {
                System.out.println("Please enter a positive integer for number of rounds.");
                setMaxRounds();
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid integer for number of rounds.");
            setMaxRounds();
        }
    }

    /**
     * Starts the game by creating players, creating and shuffling the deck, and distributing the cards.
     */
    public void startGame() {
        createPlayers();
        deck = new GroupOfCards(52);
        deck.createDeck();
        deck.shuffle();

        distributeCards();
    }

    /**
     * Creates two players for the game by prompting the user to enter their names.
     */
    public void createPlayers() {
        input = new Scanner(System.in);

        System.out.println("Enter player 1 name: ");
        String name1 = input.nextLine();
        player1 = new WarPlayer(name1);

        System.out.println("Enter player 2 (Computer's) name: ");
        String name2 = input.nextLine();
        player2 = new WarPlayer(name2);

        System.out.println("Player 1: " + player1.getName());
        System.out.println("Player 2: " + player2.getName());
    }

    /**
     * Distributes the cards in the deck to the players.
     * Alternates between the players and removes the top card from the deck.
     */
    public void distributeCards() {
        while (!deck.getAllCards().isEmpty()) {
            player1.collectCard(deck.getAllCards().remove(0));
            player2.collectCard(deck.getAllCards().remove(0));
        }
    }

    /**
     * Starts a battle between the two players by drawing the top card from each player's hand.
     * Compares the values of the cards and determines the winner.
     * If there is a tie, starts a war.
     */
    public void startBattle() {
        System.out.println("─── ROUND " + (currentRound+1) + " ──────────────────────────────\n");
        WarCard card1 = player1.drawTopCard();
        WarCard card2 = player2.drawTopCard();

        System.out.println(player1.getName() + " draws: " + card1);
        System.out.println(player2.getName() + " draws: " + card2);
        System.out.println("\n");

        int comparison = card1.getValue().compareTo(card2.getValue());
        if (comparison > 0) {
            player1.collectCard(card1, card2);
            System.out.println(":-)   " + player1.getName() + " WINS this round.");
        } else if (comparison < 0) {
            player2.collectCard(card1, card2);
            System.out.println(":-)   " + player2.getName() + " WINS this round.");
        } else {
            startWar();
        }

        displayCardCount();
    }

    /**
     * Starts a war between the two players by placing three cards face-down and one card face-up.
     * Compares the values of the face-up cards and determines the winner.
     * If there is a tie, continues the war recursively.
     */
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
            warCardsP1[i] = player1.play();;
            warCardsP2[i] = player2.play();
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
            startWar();  // If it's a tie again, continue the war
        }
    }

    /**
     * Displays the number of cards remaining in each player's hand.
     */
    private void displayCardCount() {
        System.out.println("---->>>>>   " + player1.getName() + " has " + player1.getHand().getAllCards().size() + " cards remaining.");
        System.out.println("---->>>>>   " + player2.getName() + " has " + player2.getHand().getAllCards().size() + " cards remaining.");
        System.out.println("\n");
    }

    /**
     * Checks if the game is over by comparing the current round to the maximum number of rounds or checking if either player has an empty hand.
     * If the game is over, declares the winner.
     * @return true if the game is over, false otherwise
     */
    private boolean gameOver() {
        if (currentRound >= MAX_ROUNDS) {
            declareWinner(); // Declare the winner immediately
            return true;
        }
        return player1.getHand().getAllCards().isEmpty() || player2.getHand().getAllCards().isEmpty();
    }

    /**
     * Prompts the user to play again and resets the current round counter if they choose to play again.
     * @return true if the user wants to play again, false otherwise
     */
    private boolean playAgain() {
        System.out.println("Do you want to play again? (yes/no)");
        String response = input.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            currentRound = 0; // Reset round counter
            return true;
        }
        return false;
    }

    /**
     * Prompts the user to press ENTER to continue to the next round.
     */
    private void promptToContinue() {
        System.out.println("\n───────────────────────────────────────");
        System.out.println("Press ENTER to proceed to the next round...");
        input.nextLine();
        System.out.println("───────────────────────────────────────\n");
    }

    /**
     * Declares the winner of the game based on the number of cards each player has.
     * If the maximum number of rounds has been reached, declares the winner immediately.
     */
    @Override
    public void declareWinner() {
        if (currentRound >= MAX_ROUNDS) {
            System.out.println("Game ended due to reaching max rounds.");

            int player1CardsCount = player1.getHand().getAllCards().size();
            int player2CardsCount = player2.getHand().getAllCards().size();

            if (player1CardsCount > player2CardsCount) {
                System.out.println(player1.getName() + " wins with " + player1CardsCount + " cards!");
            } else if (player2CardsCount > player1CardsCount) {
                System.out.println(player2.getName() + " wins with " + player2CardsCount + " cards!");
            } else {
                System.out.println("It's a tie!");
            }
        } else if (player1.getHand().getAllCards().isEmpty()) {
            System.out.println(player2.getName() + " wins!");
        } else if (player2.getHand().getAllCards().isEmpty()) {
            System.out.println(player1.getName() + " wins!");
        }
    }

    /**
     * Starts the game by calling startGame() and then enters a loop to play the game until the user chooses to quit.
     * Calls startBattle() to start each round and increments the current round counter.
     * Calls declareWinner() when the game is over.
     */
    @Override
    public void play() {
        do {
            startGame();

            while (!gameOver()) {
                promptToContinue();
                startBattle();
                currentRound++;
            }

            // declareWinner();
        } while (playAgain());
    }
}