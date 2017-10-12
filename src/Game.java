import javax.swing.JOptionPane;
public class Game {
    private GameWindow window;
    private String currentAnswer;
    private int currentPlayer = 0;

    public Game() {
        window = new GameWindow(600, 600);
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