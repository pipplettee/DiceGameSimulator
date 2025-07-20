# Dice Game Simulator

This project is a simple, multiplayer dice-rolling game created for a university project. Players take turns rolling a six-sided die, and the player with the highest roll wins the round.

This repository contains two versions of the game:
1.  A **Java Swing desktop application** (the original project).
2.  A **web-based version** (HTML, CSS, JS) for easy online play and demonstration.

## Features

- **Multiplayer Support**: Play with 2 to 4 players.
- **Round-Based Gameplay**: Continue playing rounds to see who gets the most wins.
- **Win Tracking**: The game automatically keeps score.
- **Tie Handling**: If multiple players roll the highest number, the round is declared a tie and no one wins.

---

## Playable Web Version

You can play the web version of the game by opening the `index.html` file located in the `web-version` folder.

For a live demo, you can host this folder using GitHub Pages.

---

## How to Run the Original Java Version

The source code for the Java desktop application is located in the `/java-version` directory.

### Prerequisites

- You must have the **Java Development Kit (JDK)** installed on your system.

### Steps to Run

1.  **Clone the Repository**
    ```bash
    git clone <your-repository-url>
    ```

2.  **Navigate to the Java Source Folder**
    Open your terminal or command prompt and navigate to the correct directory:
    ```bash
    cd DiceGameSimulator/java-version
    ```

3.  **Compile the Java Code**
    Use the Java compiler (`javac`) to compile all the `.java` files:
    ```bash
    javac *.java
    ```

4.  **Run the Application**
    Execute the main class to launch the GUI:
    ```bash
    java DiceGameGUI
    ```
The game window will now appear on your screen.
