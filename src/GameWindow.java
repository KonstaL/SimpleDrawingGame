import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Component;

public class GameWindow extends JFrame {
    public GameWindow(int width, int height) {
        setSize(width, height);
        setVisible(true);
        askUsername(this);
        
    }

    public String askUsername(Component parent) {
        String player1;
        return JOptionPane.showInputDialog(parent, "Please enter name");
    }
}