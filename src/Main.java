import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Main {

    JButton clearBtn, blackBtn;
    DrawArea drawArea;
    ActionListener actionlistener = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clearBtn) {
                drawArea.clear();
            } else if (e.getSource() == blackBtn) {
                drawArea.black();
            }
        }
    };

    public static void main(String[] args) {
        new Main().show();
    }

    public void show() {
        //GameWindow test = new GameWindow(400, 400);
        JFrame frame = new JFrame();
        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        final DrawArea drawArea = new DrawArea();
        content.add(drawArea, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener(actionlistener);
        blackBtn = new JButton("Black");
        blackBtn.addActionListener(actionlistener);
        controls.add(clearBtn);
        controls.add(blackBtn);

        content.add(controls, BorderLayout.NORTH);

        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}