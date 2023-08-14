package ca.sheridancollege.project;

public class WarGame extends Game {

    public WarGame(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void declareWinner() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'declareWinner'");
    }

    //this method will start the game
    public void startGame() {

    }

    @Override
    public void play() {
        while (players.get(0).getDeck().getCards().size() > 0 && players.get(1).getDeck().getCards().size() > 0) {
            Card player1Card = players.get(0).drawTopCard();
            Card player2Card = players.get(1).drawTopCard();

            int compareResult = player1Card.getValue().compareTo(player2Card.getValue());

            if (compareResult > 0) {
                players.get(0).collectCard(player1Card, player2Card);
            } else if (compareResult < 0) {
                players.get(1).collectCard(player1Card, player2Card);
            } else {
                // War logic can be implemented here. For simplicity, we will not include the war logic in this example.
            }
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        if (players.get(0).getDeck().getCards().size() > players.get(1).getDeck().getCards().size()) {
            System.out.println(players.get(0).getName() + " is the winner!");
        } else if (players.get(0).getDeck().getCards().size() < players.get(1).getDeck().getCards().size()) {
            System.out.println(players.get(1).getName() + " is the winner!");
        } else {
            System.out.println("It's a tie!");
        }
    }

}
