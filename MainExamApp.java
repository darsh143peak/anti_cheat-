import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainExamApp {

    public static void main(String[] args) {

        CheatingScoreEngine engine = new CheatingScoreEngine();

        JFrame frame = new JFrame("ONLINE EXAM - DO NOT SWITCH");

        // Fullscreen lockdown
        frame.setUndecorated(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);

        JLabel label = new JLabel("📝 Exam in Progress...", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 26));
        frame.add(label);

        // 🔑 IMPORTANT for key detection
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        // ALT + F4 detection
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F4) {
                    engine.addScore(20, "Attempted ALT+F4");
                }
            }
        });

        // REAL detectors
        new WindowFocusDetector(frame, engine);
        new ClipboardMonitor(engine).start();
        new AlertSystem(engine).start();

        frame.setVisible(true);
        frame.requestFocus(); // VERY IMPORTANT
    }
}
