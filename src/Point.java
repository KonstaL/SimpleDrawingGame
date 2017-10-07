import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Point extends JPanel {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(50,50,50,50);
    }
}