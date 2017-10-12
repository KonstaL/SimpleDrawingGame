/*
* The class Game initates the main GameWindow and dialog to ask players
* usernames.
*/
public class Game {

    // Main game window
    private GameWindow window;

    public Game() {
        window = new GameWindow(600, 600);
        window.setPlayers(window.askUsername(window));
    }
}