import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;


public class GameWindow extends JFrame {
    //private List<Point> points;
    public GameWindow(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        askUsername(this);
        setVisible(true);

        /*
        points = new LinkedList<>();
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = new Point(e.getX(), e.getY());
                add(point);
                points.add(point);
                
                revalidate();
                repaint();
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = new Point(e.getX(), e.getY());
                add(point);
                points.add(point);
                
                revalidate();
                repaint();
            }
        });
        */
    }

    public String[] askUsername(Component parent) {
        String[] players = new String[2]; //Hardcoded to string and limited to 2 for now
        do {
            players[0] = JOptionPane.showInputDialog(parent, "Player 1!\nPlease enter name");
            players[1] = JOptionPane.showInputDialog(parent, "Player 2!\nPlease enter name");
        } while (players[0].length() <= 0 || players[1].length() <= 0);
        return players;
    }
    
    /*
    class Point extends JPanel {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(Point point : points) {
                g.setColor(Color.RED);
                g.fillOval(point.x, point.y, 10, 10);

                revalidate();
                repaint();
            }
        }
    }
    */
}