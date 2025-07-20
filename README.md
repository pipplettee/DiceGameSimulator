# Dice Game Simulator (Java Edition)

This project is a simple, multiplayer dice-rolling game built entirely in Java with a Swing GUI. Players take turns rolling a six-sided die, and the player with the highest roll wins the round.

This application is packaged as a runnable `.jar` file, which is the standard method for distributing Java desktop applications.

## Features

- **Java-Based GUI**: The user interface is built using the Java Swing framework.
- **Multiple Players**: Supports 2 to 4 players.
- **Round-Based Gameplay**: Play as many rounds as you like.
- **Score Tracking**: Automatically tracks the number of wins for each player.
- **Tie Detection**: Correctly handles rounds where there is a tie for the highest score.

---

## 🎲 How to Play the Game

You can run this game by downloading the single executable `.jar` file.

### Prerequisites

- You must have **Java** installed on your computer (version 8 or newer).

### Steps to Run

1.  **Download the Game:**
    Download the   `DiceGame.jar` file.

2.  **Run the Application:**
    You can run the game in one of two ways:

    **A) From the Command Line (Recommended):**
    Open a terminal or command prompt, navigate to the folder where you downloaded the file, and run the following command:
    ```bash
    java -jar DiceGame.jar
    ```

    **B) By Double-Clicking:**
    On most systems, you can simply **double-click** the `DiceGame.jar` file to launch the application.

The game window should now appear on your screen!

---

## Source Code

The complete source code for the project is located in the `/java-files` directory. It is structured into the following classes:

- `Dice.java`: Simulates a six-sided die.
- `Player.java`: Represents a player with a name and win count.
- `GameEngine.java`: Contains the core game logic.
- `DiceGameGUI.java`: The main class that builds the GUI and runs the application.
