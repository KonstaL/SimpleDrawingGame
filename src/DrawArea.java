import javax.swing.JComponent;
import java.awt.event.MouseEvent;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/*
* The DrawArea class initates the drawing area of the game and handles all the functionality
* that is included in the drawing, clearing, color change and brush size in the game. Acts as
* a component in the GameWindow frame.
*/
class DrawArea extends JComponent {

    // Image in which we're going to draw
    private Image image;

    // Graphics2D object ==> used to draw on
    private Graphics2D g2;
    
    // Mouse coordinates
    private int currentX, currentY, oldX, oldY;

    private int brushSize;

    public DrawArea() {
        brushSize = 1;
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
                // Coord x,y when mouse dragged
                currentX = e.getX();
                currentY = e.getY();

                // Draw line if g2 content not null
                if (g2 != null) {
                    // Draws more lines under the first one based on brush size.
                    for(int i = 0; i < brushSize; i++) {
                        g2.drawLine(oldX + i, oldY + i, currentX + i, currentY + i);
                    }
                    
                    // Repaint to refresh draw area
                    repaint();
                    // Set old coords x,y as current coords x,y
                    oldX = currentX;
                    oldY = currentY;
                }
            }
        });
    }

    /*
    * Painting method that draws image based on drawings made in mouseDragged.
    * 
    * @param g      graphics that are set to be painted
    */
    protected void paintComponent(Graphics g) {
        if (image == null) {
            // Image to draw null ==> we create
            image = createImage(getSize().width, getSize().height);
            g2 = (Graphics2D) image.getGraphics();
            // Enable antialiasing
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                 RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }

        g.drawImage(image, 0, 0, null);

    }

    /*
    * Simple method to repaint the shole draw area white and set the
    * painting color black.
    */
    public void clear() {
       g2.setPaint(Color.WHITE);
       // Draw white on entire draw area to clear
       g2.fillRect(0, 0, getSize().width, getSize().height);
       g2.setPaint(Color.BLACK);
       repaint(); 
    }

    public void reduceBrush() {
        if(brushSize > 1) {
            brushSize--;
        }
    }
    public void setColor(Color c) {
        g2.setPaint(c);
    }

    /*
    * Increases the brush size by 1.
    */
    public void increaseBrush() {
        brushSize++;
    }
}