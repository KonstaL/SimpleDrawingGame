import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.colorchooser.*;

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

        JColorChooser jcl = new JColorChooser();
        
        AbstractColorChooserPanel[] panels = jcl.getChooserPanels();
        for(AbstractColorChooserPanel p:panels) {
            String displayName=p.getDisplayName();
            switch (displayName) {
                case "HSV":
                    jcl.removeChooserPanel(p);
                    break;
                case "HSL":
                    jcl.removeChooserPanel(p);
                    break;
                case "CMYK":
                    jcl.removeChooserPanel(p);
                    break;
                case "RGB":
                    jcl.removeChooserPanel(p);
                    break;
            }
        }
        jcl.setPreviewPanel(new JPanel());   

        AbstractColorChooserPanel colorPanel = jcl.getChooserPanels()[0];
        JPanel c = (JPanel) colorPanel.getComponent(0);
        c.remove(2);
        c.remove(1);
        
        optionsContainer.add(colorSelect, BorderLayout.NORTH);
        optionsContainer.add(controls, BorderLayout.SOUTH);

        add(jcl, BorderLayout.SOUTH);
        add(optionsContainer, BorderLayout.NORTH);
        add(drawArea, BorderLayout.CENTER);
        setVisible(true);
    }

    public void setPlayers(String[] p) {
        this.players = p;
    }
    public String[] getPlayers() {
        return this.players;
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