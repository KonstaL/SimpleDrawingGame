import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.colorchooser.*;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.event.ChangeEvent;

public class GameWindow extends JFrame {
    private DrawArea drawArea;
    private String[] players;
    JButton clearBtn,
            mBtn,
            pBtn;

    public GameWindow(int width, int height) {
        ActionListener a = (ActionEvent e)-> {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
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
        mBtn = new JButton("-");
        pBtn = new JButton("+");

        clearBtn.addActionListener(a);
        mBtn.addActionListener(a);
        pBtn.addActionListener(a);

        JPanel colorContainer = new JPanel(new BorderLayout());
        JPanel buttonContainer = new JPanel();
        buttonContainer.setLayout(new BoxLayout(buttonContainer, BoxLayout.Y_AXIS));
        buttonContainer.setBorder(BorderFactory.createEmptyBorder(10,10,10,45));
       

        buttonContainer.add(clearBtn);
        buttonContainer.add(Box.createRigidArea(new Dimension(0,5)));
      

        JPanel controls = new JPanel();
        buttonContainer.add(mBtn);
        buttonContainer.add(Box.createRigidArea(new Dimension(0,5)));
        buttonContainer.add(pBtn);
        buttonContainer.add(Box.createRigidArea(new Dimension(0,5)));

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
        jcl.getSelectionModel().addChangeListener((ChangeEvent e) -> drawArea.setColor(jcl.getColor()));

        AbstractColorChooserPanel colorPanel = jcl.getChooserPanels()[0];
        JPanel c = (JPanel) colorPanel.getComponent(0);
        c.remove(2);
        c.remove(1);
        
     

        colorContainer.add(jcl, BorderLayout.CENTER);
        colorContainer.add(buttonContainer, BorderLayout.EAST);

        add(colorContainer, BorderLayout.SOUTH);
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