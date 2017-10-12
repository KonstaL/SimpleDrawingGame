import javax.swing.JOptionPane;
import java.util.List;
/*
* The class Game initates the main GameWindow and dialog to ask players
* usernames.
*/

public class Game {
    
    private GameWindow window;
    private boolean gameActive = true;
    private String currentAnswer;
    private Player currentPlayer;
    private Player tempPlayer;

    public Game() {
        window = new GameWindow(800, 800);
        window.setPlayers(window.askUsername(window));
        Thread t = new Thread(this::initGame);
        t.start();
    }

    private void initGame() {
        while(gameActive) {
            setCurrentPlayer();
            setCurrentAnswer(
                JOptionPane.showInputDialog(window, currentPlayer.getName() + "\nWhat are you drawing?"));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getCurrentAnswer() {
        return currentAnswer;
    }

    private void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    private Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer() {
        List<Player> p = window.getPlayers();
        currentPlayer = p.get((int)(Math.random()*p.size()) + 0);
        while(tempPlayer != null && tempPlayer.getName().equals(currentPlayer.getName())) {
            currentPlayer = p.get((int)(Math.random()*p.size()) + 0);
        }
        tempPlayer = currentPlayer;
    }
}