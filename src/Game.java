public class Game {
    private GameWindow window;

    public Game() {
        window = new GameWindow(600, 600);
        window.setPlayers(window.askUsername(window));
    }
}