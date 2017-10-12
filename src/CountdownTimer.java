import javax.swing.*;
public class CountdownTimer extends JLabel {
    private int remainingTime = 60;
    private Timer timer;
    public CountdownTimer() {
        timer = new Timer(1000, (e) -> {
            remainingTime--;
            repaint();
        });
    }
    public Timer getTimer() {
        return this.timer;
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    @Override
    public String getText() {
        return Integer.toString(remainingTime);
    }
}
