import java.awt.BorderLayout;
import java.awt.Container;

public class Main {
    public static void main(String[] args) {
        GameWindow test = new GameWindow(400, 400);
        Container content = test.getContentPane();
        content.setLayout(new BorderLayout());
        final DrawArea drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);
    }
}