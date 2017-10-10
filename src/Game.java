import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Game {
    private GameWindow window;
    private DrawArea drawArea;
    JButton clearBtn,
            blackBtn,
            redBtn,
            greenBtn,
            blueBtn;
    ActionListener actionlistener;

    public Game() {
        actionlistener = (ActionEvent e)-> {
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
                } else {
                    System.out.println("Some other source"); //for debugging
                }
        };

        window = new GameWindow(600, 600);
        drawArea = new DrawArea();
        
        clearBtn = new JButton("Clear");
        blackBtn = new JButton("Black");
        redBtn = new JButton("Red");
        greenBtn = new JButton("Green");
        blueBtn = new JButton("Blue");

        redBtn.addActionListener(actionlistener);
        greenBtn.addActionListener(actionlistener);
        blackBtn.addActionListener(actionlistener);
        clearBtn.addActionListener(actionlistener);
        blueBtn.addActionListener(actionlistener);
        
        JPanel controls = new JPanel();
        controls.add(clearBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(greenBtn);
        controls.add(blueBtn);

        window.add(controls, BorderLayout.NORTH);
        window.add(drawArea, BorderLayout.CENTER);
        window.setVisible(true);
        askUsername(window);
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