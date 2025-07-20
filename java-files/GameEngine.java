import java.util.List;
import java.util.ArrayList;

public class GameEngine {
    private List<Player> players;
    private Dice dice;

    public GameEngine(List<Player> players) {
        this.players = players;
        this.dice = new Dice();
    }

    
    public String playRound() {
        if (players == null || players.isEmpty()) {
            return "No players in the game.";
        }

        int maxScore = 0;
        Player winner = null;
        boolean isTie = false;
        StringBuilder roundResults = new StringBuilder();

        List<Integer> rolls = new ArrayList<>();
        for (Player player : players) {
            int roll = dice.roll();
            rolls.add(roll);
            roundResults.append(player.getName()).append(" rolled a ").append(roll).append(".<br>");

            if (roll > maxScore) {
                maxScore = roll;
                winner = player;
                isTie = false;
            } else if (roll == maxScore) {
                isTie = true;
            }
        }

        if (isTie) {
            roundResults.append("<br><b>It's a tie this round! No winner.</b>");
        } else if (winner != null) {
            winner.incrementWins();
            roundResults.append("<br><b>").append(winner.getName()).append(" wins the round with a roll of ").append(maxScore).append("!</b>");
        }
        
        return "<html>" + roundResults.toString() + "</html>";
    }

    public String showResults() {
        StringBuilder results = new StringBuilder("--- Current Standings ---<br>");
        for (Player player : players) {
            results.append(player.getName()).append(": ").append(player.getWins()).append(" wins<br>");
        }
        return "<html>" + results.toString() + "</html>";
    }
}

