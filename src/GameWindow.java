import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Component;

public class GameWindow extends JFrame {
    public GameWindow(int width, int height) {
        setSize(width, height);
        setVisible(true);
        askUsername(this);
        
    }

    public String[] askUsername(Component parent) {
        String[] players = new String[2]; //Hardcoded to string and limited to 2 for now
        do {
            players[0] = JOptionPane.showInputDialog(parent, "Player 1!\nPlease enter name");
            players[1] = JOptionPane.showInputDialog(parent, "Player 2!\nPlease enter name");
        } while (players[0].length() <= 0 || players[1].length() <= 0);
        return players;
    }
}