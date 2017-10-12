
import javax.swing.JOptionPane;
=======
/*
* The class Game initates the main GameWindow and dialog to ask players
* usernames.
*/

public class Game {

    // Main game window
    private GameWindow window;
    private String currentAnswer;
    private int currentPlayer = 0;

    public Game() {
        window = new GameWindow(800, 800);
        window.setPlayers(window.askUsername(window));
        initGame();
    }

    private void initGame() {
        setCurrentAnswer(
                JOptionPane.showInputDialog(window, "Player " + getCurrentPlayer() + "\nWhat are you drawing?")
        );
    }

    private String getCurrentAnswer() {
        return currentAnswer;
    }

    private void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    private int getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

}