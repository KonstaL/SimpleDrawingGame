import javax.swing.JOptionPane;
import java.util.List;
/*
* The class Game initiates the main GameWindow and dialog to ask players
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
    /*
    * The initGame method functions as a "game loop",
    * carrying out all necessary gameplay operations concerning player input.
    * */
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
            getPlayerGuess();
            checkCorrectAnswers();
        }
    }
    /*
    * The setCurrentPlayer() method randomly sets which player draws next,
    * excluding the person that drew the last image.
    * */
    private void setCurrentPlayer() {
        List<Player> p = window.getPlayers();
        currentPlayer = p.get((int)(Math.random()*p.size()) + 0);
        while(tempPlayer != null && tempPlayer.getName().equals(currentPlayer.getName())) {
            currentPlayer = p.get((int)(Math.random()*p.size()) + 0);
        }
        tempPlayer = currentPlayer;
    }
    /*
    * The getPlayerGuess() method loops over all players (excluding current player),
    * opening a dialog for player guesses regarding the current image.
    * */
    private void getPlayerGuess() {
        window.getPlayers().stream().forEach(p -> {
            if(!(p.getName().equals(currentPlayer.getName()))) {
                p.setGuess(JOptionPane.showInputDialog(window, "Guess!"));
            }
        });
    }
    private void checkCorrectAnswers() {
        window.getPlayers().stream().forEach(p -> {
            if(!(p.getName().equals(currentPlayer.getName())) && p.getGuess().equals(getCurrentAnswer())) {
                p.setPoints(1);
            }
        });
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
}