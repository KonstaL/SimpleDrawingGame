import javax.swing.*;
/*
* CountdownTimer class is used to graphically represent a countdown clock
* on the GUI.
* */
public class CountdownTimer extends JLabel {
    private int remainingTime = 30;
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
    public void setRemainingTime(int t) {
        this.remainingTime = t;
    }
    public void resetTimer() {
        setRemainingTime(30);
        repaint();
    }

    @Override
    public String getText() {
        return Integer.toString(remainingTime);
    }
}
