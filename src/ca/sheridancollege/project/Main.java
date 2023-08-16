package ca.sheridancollege.project;
/**
 * @author Jaskaran Sharma Punj
 */
public class Main {
    /**
     * This method runs the game by creating a new game object and calling the play method in game class.
     */
    public static void main(String[] args) {
        Game war = new WarGame("War");
        war.play();
    }
}
