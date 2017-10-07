import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameWindow extends JFrame {
    public GameWindow(int width, int height) {
        setSize(width, height);
        setVisible(true);
        askUsername();
        
    }

    public String askUsername() {
        String player1;
        return JOptionPane.showInputDialog(null, "Please enter name");
    }
}