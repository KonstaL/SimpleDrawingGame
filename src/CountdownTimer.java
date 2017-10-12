import javax.swing.*;
/*
* CountdownTimer class is used to graphically represent a countdown clock
* on the GUI.
* */
public class CountdownTimer extends JLabel {
    private int remainingTime = 30;
    private Timer timer;
    /*
    * Constructor method for CountdownTimer.
    * */
    public CountdownTimer() {
        timer = new Timer(1000, (e) -> {
            remainingTime--;
            repaint();
        });
    }
    /*
    * Simple method for requesting instance of CountdownTimer object.
    *
    * @return       return instance of this CountdownTimer
    * */
    public Timer getTimer() {
        return this.timer;
    }
    /*
    * Simple method for setting the remainingTime attribute.
    * */
    public void setRemainingTime(int t) {
        this.remainingTime = t;
    }
    /*
    * Method used for resetting the remainingTime to max value.
    * */
    public void resetTimer() {
        setRemainingTime(30);
        repaint();
    }

    @Override
    public String getText() {
        return Integer.toString(remainingTime);
    }
}
