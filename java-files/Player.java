/**
 * The Player class represents a player in the dice game.
 */
public class Player {
    private String name;
    private int wins;

    /**
     * Constructor for the Player class.
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    /**
     * Gets the name of the player.
     * @return The player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the number of wins for the player.
     * @return The total number of wins.
     */
    public int getWins() {
        return wins;
    }

    /**
     * Increments the player's win count by one.
     */
    public void incrementWins() {
        this.wins++;
    }
}

