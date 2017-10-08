import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

class DrawArea extends JComponent {

    // Image in which we're going to draw
    private Image image;

    // Gtraphics2D object ==> used to draw on
    private Graphics2D graphics;
    
    // Mouse coordinates
    private int currentX, currentY, oldX, oldY;

    public DrawArea() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                // Save coord x,y when mouse is pressed
                oldX = e.getX();
                oldY = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) {
                // Coord x,y when mosue dragged
                currentX = e.getX();
                currentY = e.getY();

                if (g2 != null) {
                    // Draw line if g2 content not null
                    g2.drawLine(oldX, oldY, currentX, currentY);
                    // Refresh draw area to repaint
                    repaint();
                    // Sotre current coordx x,y as old coords x,y
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            // Image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // Enable antialiasing
            g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }

        g.drawImage(image, 0, null);

    }

    public void clear() {
        
    }
}