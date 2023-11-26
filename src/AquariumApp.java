import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class AquariumApp extends JFrame {

    private final AquariumBackground aquariumBackground;
    public static int appWidth = 800;
    public static int appHeight = 600;
    public AquariumApp() {
        aquariumBackground = new AquariumBackground();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(appWidth, appHeight);
        setTitle("Moje akwarium");

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                handleResize();
            }
        });

        setVisible(true);
    }

    private void handleResize() {
        appWidth = getWidth();
        appHeight = getHeight();
//        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        aquariumBackground.showBackground(g);
    }
}
