import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main {

    JButton clearBtn, blackBtn, redBtn, greenBtn, blueBtn;
    DrawArea drawArea;
    ActionListener actionlistener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            } else if (e.getSource() == redBtn) {
                drawArea.red();
            } else if (e.getSource() == greenBtn) {
                drawArea.green();
            } else if (e.getSource() == blueBtn) {
                drawArea.blue();
            }
        }
    };

    public static void main(String[] args) {
        new Main().show();
    }

    public void show() {
        GameWindow window = new GameWindow(600, 600);
        Container content = window.getContentPane();
        content.setLayout(new BorderLayout());
        final DrawArea drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionlistener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionlistener);
        redBtn = new JButton("Red");
        redBtn.addActionListener(actionlistener);
        greenBtn = new JButton("Green");
        greenBtn.addActionListener(actionlistener);
        blueBtn = new JButton("Blue");
        blueBtn.addActionListener(actionlistener);
        controls.add(clearBtn);
        controls.add(blackBtn);
        controls.add(redBtn);
        controls.add(greenBtn);
        controls.add(blueBtn);
        content.add(controls, BorderLayout.NORTH);
        window.setVisible(true);
    }
}