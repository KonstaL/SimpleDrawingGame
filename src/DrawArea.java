import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

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
    }
}