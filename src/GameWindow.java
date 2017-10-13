import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.colorchooser.*;
import javax.swing.event.ChangeEvent;

/*
* The GameWindow class extends JFrame to hold all the buttons and controls of the game.
*/
public class GameWindow extends JFrame {
    private DrawArea drawArea;
    private List<Player> players;
    private CountdownTimer ct;
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
        
        setSize(width, height);
        setResizable(false);
        setTitle("Drawing game!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        drawArea = new DrawArea();

        clearBtn = new JButton("Clear");
        mBtn = new JButton("-");
        pBtn = new JButton("+");

        ActionListener a = new ActionEventListener();
        clearBtn.addActionListener(a);
        mBtn.addActionListener(a);
        pBtn.addActionListener(a);

        JPanel colorContainer = new JPanel(new BorderLayout());
        JPanel buttonContainer = new JPanel();

        buttonContainer.setLayout(new GridLayout(3,1));

        buttonContainer.add(clearBtn);
        buttonContainer.add(mBtn);
        buttonContainer.add(pBtn);
      
        JColorChooser jcl = initColorChooser();
       
        colorContainer.add(jcl, BorderLayout.CENTER);
        colorContainer.add(buttonContainer, BorderLayout.EAST);

        ct = new CountdownTimer();
        ct.setBounds(getWidth()/2-25, 0, 50, 50);
        ct.setFont(new Font("Mono", Font.BOLD, 40));
        ct.setForeground(Color.magenta);

        add(ct);
        add(colorContainer, BorderLayout.SOUTH);
        add(drawArea, BorderLayout.CENTER);
        setVisible(true);
    }

    /*
    * Method for getting draw area.
    *
    * @return       instance of DrawArea class
    * */
    public DrawArea getDrawArea() {
        return drawArea;
    }

    /*
        * Simple set method for setting player names Player List into GameWindow.
        *
        * @param p      String array with player names in it
        */
    public void setPlayers(List<Player> p) {
        this.players = p;
    }

    /*
    * Simple get method for string array of player names in the GameWindow.
    *
    * @return       player names in a Player List
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
        int n = 0;

        //Try to ask how many players there will be playing
        do {
            try {
                n = Integer.parseInt(JOptionPane.showInputDialog(parent, "How many players will be playing?"));
            } catch(Exception e) {
                e.printStackTrace();
            }
        } while(n < 2);

        //Ask usernames according to n amount
        for(int i = 0; i < n; i++) {
            Player player = null;

            //Ask a username until one is given
            do {
                String name = JOptionPane.showInputDialog(parent, "Player " + (i+1) + "!\nPlease enter name");
                if(name == null) {
                    player = new Player("");
                } else {
                    player = new Player(name);
                }
            } while (player.getName().length() < 1);

            //Add the player to the list that were going to return
            players.add(player);
        }
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

    public CountdownTimer getCt() {
        return ct;
    }

    public void clear() {
        drawArea.clear();
    }
    private class ActionEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == mBtn) {
                drawArea.reduceBrush();
            } else if (e.getSource() == pBtn) {
                drawArea.increaseBrush();
            } else {
                System.out.println("Some other source"); //for debugging
            }
        }            
    }
}