import javax.swing.*;
public class CountdownTimer extends JLabel {
    public CountdownTimer() {
        Timer timer = new Timer(1000, (e) -> repaint());
        timer.start();
    }
}
