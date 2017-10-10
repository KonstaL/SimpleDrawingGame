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
            blueBtn,
            mBtn,
            pBtn;

    public Game() {
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

        window.add(optionsContainer, BorderLayout.NORTH);
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