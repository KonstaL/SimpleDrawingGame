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

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}