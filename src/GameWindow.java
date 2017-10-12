import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

/*
* The GameWindow class extends JFrame to hold all the buttons and controls of the game.
*/
public class GameWindow extends JFrame {
    private DrawArea drawArea;
    private String[] players;
    JButton clearBtn,
            blackBtn,
            redBtn,
            greenBtn,
            blueBtn,
            mBtn,
            pBtn;

    /*
    * Constructor of the game window.
    *
    * @param width      width of the game window
    * @param height     height of the game window
    */
    public GameWindow(int width, int height) {
        ActionListener a = (ActionEvent e)-> {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == redBtn) {
                drawArea.red();
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            } else if (e.getSource() == mBtn) {
                drawArea.reduceBrush();
            } else if (e.getSource() == pBtn) {
                drawArea.increaseBrush();
            } else {
                System.out.println("Some other source"); //for debugging
            }
        };

        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawArea = new DrawArea();

        clearBtn = new JButton("Clear");
        blackBtn = new JButton("Black");
        redBtn = new JButton("Red");
        greenBtn = new JButton("Green");
        blueBtn = new JButton("Blue");
        mBtn = new JButton("-");
        pBtn = new JButton("+");

        redBtn.addActionListener(a);
        greenBtn.addActionListener(a);
        blackBtn.addActionListener(a);
        clearBtn.addActionListener(a);
        blueBtn.addActionListener(a);
        mBtn.addActionListener(a);
        pBtn.addActionListener(a);

        JPanel optionsContainer = new JPanel(new BorderLayout());

        JPanel colorSelect = new JPanel();
        colorSelect.add(clearBtn);
        colorSelect.add(blackBtn);
        colorSelect.add(redBtn);
        colorSelect.add(greenBtn);
        colorSelect.add(blueBtn);

        JPanel controls = new JPanel();
        controls.add(mBtn);
        controls.add(pBtn);

        optionsContainer.add(colorSelect, BorderLayout.NORTH);
        optionsContainer.add(controls, BorderLayout.SOUTH);

        add(optionsContainer, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);
        setVisible(true);
    }

    /*
    * Simple set method for setting player names String array into GameWindow.
    *
    * @param p      String array with player names in it
    */
    public void setPlayers(String[] p) {
        this.players = p;
    }

    /*
    * Simple get method for string array of player names in the GameWindow.
    *
    * @return       player names in a String array
    */
    public String[] getPlayers() {
        return this.players;
    }

    /*
    * Ask the username of the players playing the game. Shows dialog popups.
    *
    * @param parent     the parent Component where the user input dialog is added to
    * @return           players names in a String array
    */
    public String[] askUsername(Component parent) {
        String[] players = new String[2]; //Hardcoded to string and limited to 2 for now
        do {
            players[0] = JOptionPane.showInputDialog(parent, "Player 1!\nPlease enter name");
            players[1] = JOptionPane.showInputDialog(parent, "Player 2!\nPlease enter name");
        } while (players[0].length() <= 0 || players[1].length() <= 0);
        return players;
    }
}