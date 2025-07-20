import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The DiceGameGUI class creates the graphical user interface for the dice game
 * and handles the game flow.
 */
public class DiceGameGUI extends JFrame {

    private GameEngine gameEngine;
    private List<Player> players;

    // UI Components
    private JPanel mainPanel;
    private CardLayout cardLayout;

    private JPanel setupPanel;
    private JPanel gamePanel;

    private JLabel roundResultLabel;
    private JLabel standingsLabel;

    /**
     * Constructor for the GUI. Sets up the main window.
     */
    public DiceGameGUI() {
        setTitle("Dice Game Simulator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        createSetupPanel();
        createGamePanel();

        mainPanel.add(setupPanel, "setup");
        mainPanel.add(gamePanel, "game");

        add(mainPanel);

        // Start with the setup panel
        cardLayout.show(mainPanel, "setup");
    }

    /**
     * Creates the initial panel for game setup (getting player count and names).
     */
    private void createSetupPanel() {
        setupPanel = new JPanel();
        setupPanel.setLayout(new BoxLayout(setupPanel, BoxLayout.Y_AXIS));
        setupPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setupPanel.setBackground(new Color(240, 248, 255)); // Alice Blue

        JLabel titleLabel = new JLabel("Welcome to the Dice Game!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton startButton = new JButton("Start Game");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.setBackground(new Color(135, 206, 250)); // Light Sky Blue
        startButton.setForeground(Color.BLACK);

        setupPanel.add(titleLabel);
        setupPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        setupPanel.add(startButton);

        startButton.addActionListener(e -> setupGame());
    }

    /**
     * Handles the logic for getting player information from the user.
     */
    private void setupGame() {
        // Get number of players
        String numPlayersStr = JOptionPane.showInputDialog(this, "How many players? (2-4)", "Player Setup", JOptionPane.QUESTION_MESSAGE);
        int numPlayers;
        try {
            numPlayers = Integer.parseInt(numPlayersStr);
            if (numPlayers < 2 || numPlayers > 4) {
                JOptionPane.showMessageDialog(this, "Please enter a number between 2 and 4.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number. Please try again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get player names
        players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            String name = JOptionPane.showInputDialog(this, "Enter name for Player " + (i + 1) + ":", "Player Setup", JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Player name cannot be empty.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                i--; // Repeat for the current player
                continue;
            }
            players.add(new Player(name));
        }

        // Initialize game engine and switch to the game panel
        gameEngine = new GameEngine(players);
        updateStandings();
        cardLayout.show(mainPanel, "game");
    }


    /**
     * Creates the main game panel where rounds are played.
     */
    private void createGamePanel() {
        gamePanel = new JPanel(new BorderLayout(10, 10));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        gamePanel.setBackground(new Color(245, 245, 220)); // Beige

        roundResultLabel = new JLabel("Click 'Play Round' to start!", SwingConstants.CENTER);
        roundResultLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        
        standingsLabel = new JLabel("Current Standings will be shown here.", SwingConstants.CENTER);
        standingsLabel.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(gamePanel.getBackground());
        centerPanel.add(roundResultLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        centerPanel.add(standingsLabel);

        JButton playRoundButton = new JButton("Play Round");
        playRoundButton.setFont(new Font("Arial", Font.PLAIN, 16));
        playRoundButton.setBackground(new Color(60, 179, 113)); // Medium Sea Green
        playRoundButton.setForeground(Color.WHITE);

        JButton exitButton = new JButton("Exit Game");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        exitButton.setBackground(new Color(255, 99, 71)); // Tomato
        exitButton.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setBackground(gamePanel.getBackground());
        buttonPanel.add(playRoundButton);
        buttonPanel.add(exitButton);

        gamePanel.add(centerPanel, BorderLayout.CENTER);
        gamePanel.add(buttonPanel, BorderLayout.SOUTH);

        playRoundButton.addActionListener(e -> {
            String result = gameEngine.playRound();
            roundResultLabel.setText(result);
            updateStandings();
        });

        exitButton.addActionListener(e -> System.exit(0));
    }

    /**
     * Updates the standings label with the latest scores.
     */
    private void updateStandings() {
        if (gameEngine != null) {
            standingsLabel.setText(gameEngine.showResults());
        }
    }

    /**
     * The main method to run the application.
     */
    public static void main(String[] args) {
        // Ensure the GUI is created on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new DiceGameGUI().setVisible(true);
        });
    }
}

