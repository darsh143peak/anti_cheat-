import java.awt.event.*;
import javax.swing.JFrame;
public class WindowFocusDetector {
    private CheatingScoreEngine engine;
    public WindowFocusDetector(JFrame frame,CheatingScoreEngine engine){
        this.engine=engine;
        frame.addWindowFocusListener(new WindowAdapter(){
            @Override
            public void windowLostFocus(WindowEvent e){
                engine.addScore(15, "Window Lost Focus (ALT+TAB Detected!)");
            }
            public void windowGainedFocus(WindowEvent e){
                ExamLogger.log("Window Regained Focus!");
            }
        });
    }
}
