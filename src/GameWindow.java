import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.colorchooser.*;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.event.ChangeEvent;

/*
* The GameWindow class extends JFrame to hold all the buttons and controls of the game.
*/
public class GameWindow extends JFrame {
    private DrawArea drawArea;
    private List<Player> players;
    JButton clearBtn,
            mBtn,
            pBtn;

    /*
    * Constructor of the game window.
    *
    * @param width      width of the game window
    * @param height     height of the game window
    */
    public GameWindow(int width, int height) {
        players = new ArrayList<>();
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
        setTitle("Drawing game!");
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
        buttonContainer.add(Box.createVerticalGlue());
        buttonContainer.add(mBtn);
        buttonContainer.add(Box.createVerticalGlue());
        buttonContainer.add(pBtn);
        buttonContainer.add(Box.createVerticalGlue());
      
        JColorChooser jcl = initColorChooser();
       
        colorContainer.add(jcl, BorderLayout.CENTER);
        colorContainer.add(buttonContainer, BorderLayout.EAST);

        add(colorContainer, BorderLayout.SOUTH);
        add(drawArea, BorderLayout.CENTER);
        setVisible(true);
    }

    /*
    * Simple set method for setting player names String array into GameWindow.
    *
    * @param p      String array with player names in it
    */
    public void setPlayers(List<Player> p) {
        this.players = p;
    }

    /*
    * Simple get method for string array of player names in the GameWindow.
    *
    * @return       player names in a String array
    */
    public List<Player> getPlayers() {
        return this.players;
    }

    /*
    * Ask the username of the players playing the game. Shows dialog popups.
    *
    * @param parent     the parent Component where the user input dialog is added to
    * @return           players names in a String array
    */
    public List<Player> askUsername(Component parent) {
        do {
            players.add(new Player(JOptionPane.showInputDialog(parent, "Player 1!\nPlease enter name")));
            players.add(new Player(JOptionPane.showInputDialog(parent, "Player 2!\nPlease enter name")));
        } while (players.size() < 2);
        return players;
    }

    public JColorChooser initColorChooser() {
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
        
          return jcl;
    }
}