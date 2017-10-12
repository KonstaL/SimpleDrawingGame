import javax.swing.*;
import java.awt.event.WindowEvent;
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

    /*
    * The class Game constructor initializes the gamewindow,
    * initializes current players and their usernames,
    * and starts the initGame() methods game loop inside a thread.
    * */
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
        CountdownTimer windowTimer = window.getCt();
        while(gameActive) {
            setCurrentPlayer();
            setCurrentAnswer(
                    JOptionPane.showInputDialog(window, currentPlayer.getName() + "\nWhat are you drawing?"));
            windowTimer.getTimer().start();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            windowTimer.getTimer().stop();
            windowTimer.resetTimer();
            getPlayerGuess();
            checkCorrectAnswers();
            if(displayScores() != 1) {
                initSystemShutdown();
            }
        }
    }
    /*
    * The initSystemShutdown() method closes the application
    * */
    private void initSystemShutdown() {
        gameActive = false;
        window.getDrawArea().clear();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
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
                p.setGuess(JOptionPane.showInputDialog(window, p.getName() + "'s turn to guess!"));
            }
        });
    }
    /*
    * The checkCorrectAnswers() method loops over all player answers (excluding current player),
    * and checks if any of the guesses match the current answer.
    * */
    private void checkCorrectAnswers() {
        window.getPlayers().stream().forEach(p -> {
            if(!(p.getName().equals(currentPlayer.getName())) && p.getGuess().equals(getCurrentAnswer())) {
                p.setPoints(1);
            }
        });
    }
    /*
    * The displayScores() method displays current game scores,
    * and prompts players to either quit or continue playing.
    * */
    private int displayScores() {
        Object[] options = {"Quit", "Continue"};
        int wishToContinue = JOptionPane.showOptionDialog(window,
                new JList<>(window.getPlayers().toArray()),
                "Current scores",
                2,
                1,
                null,
                options,
                options[1]);
        return wishToContinue;

    }


    /*
    * Method used to get currentAnswer attribute.
    *
    * @return       The correct answer for current drawing
    * */
    private String getCurrentAnswer() {
        return currentAnswer;
    }

    /*
    * Method used to set the answer to an upcoming drawing.
    *
    * @param        User inserted string that describes the drawing
    * */
    private void setCurrentAnswer(String currentAnswer) {
        this.currentAnswer = currentAnswer;
    }

    /*
    * Method used for retrieving current player.
    *
    * @return       Returns player object of current player
    * */
    private Player getCurrentPlayer() {
        return currentPlayer;
    }
}