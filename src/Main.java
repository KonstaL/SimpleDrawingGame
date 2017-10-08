import java.awt.BorderLayout;
import java.awt.Container;

public class Main {

    JButton clearBtn, blackBtn;
    DrawArea drawArea;
    ActionListener actionlistener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {

            } else if (e.getSource() == blackBtn) {
                
            }
        }
    };

    public static void main(String[] args) {
    }

    public void show() {
        GameWindow test = new GameWindow(400, 400);
        Container content = test.getContentPane();
        content.setLayout(new BorderLayout());
        final DrawArea drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        clearBtn = new JButton("Clear");
        blackBtn = new JButton("Black");
    }
}