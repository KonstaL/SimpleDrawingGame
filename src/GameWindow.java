import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class GameWindow extends JFrame {
    public GameWindow(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        askUsername(this);

        Point test = new Point();
        add(test);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Click");
            }
        });
        setVisible(true);
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