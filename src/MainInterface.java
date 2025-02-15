import javax.swing.*;

public class MainInterface {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Main Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        MyJPanel panel = new MyJPanel();
        frame.setContentPane(panel);

        MyKeyListener myKeyListener = new MyKeyListener(frame);
        frame.addKeyListener(myKeyListener);
        frame.setFocusable(true);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}