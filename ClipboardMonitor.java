import java.awt.*;
import java.awt.datatransfer.*;

public class ClipboardMonitor extends Thread {

    private CheatingScoreEngine engine;
    private String lastClipboard = null;

    public ClipboardMonitor(CheatingScoreEngine engine) {
        this.engine = engine;
    }

    public void run() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            while (true) {
                Transferable t = clipboard.getContents(null);

                if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    String data = (String) t.getTransferData(DataFlavor.stringFlavor);

                    // Ignore first read
                    if (lastClipboard == null) {
                        lastClipboard = data;
                    } 
                    else if (!data.equals(lastClipboard)) {
                        lastClipboard = data;
                        engine.addScore(10, "Clipboard changed (Copy/Paste detected)");
                    }
                }
                Thread.sleep(1500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
