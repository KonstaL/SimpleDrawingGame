import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Game {
     JButton clearBtn,
            blackBtn,
            redBtn,
            greenBtn,
            blueBtn;
    DrawArea drawArea;
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

        GameWindow window = new GameWindow(600, 600);
        Container content = window.getContentPane();
        content.setLayout(new BorderLayout());
        drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionlistener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionlistener);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionlistener);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionlistener);
        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionlistener);
        controls.add(clearBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(greenBtn);
        controls.add(blueBtn);
        content.add(controls, BorderLayout.NORTH);
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