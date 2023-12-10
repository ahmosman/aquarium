import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract public class Resource {
    String resourcesPath = "main/resources/";

    Graphics graphics;

    private final Logger logger = Logger.getLogger(getClass().getName());
    protected Image getImage(String imageName) {

        BufferedImage img = getBufferedImage(resourcesPath + imageName);

        return img.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);

    }

    protected Image getImage(String imageName, int scaleX, int scaleY) {
        BufferedImage img = getBufferedImage(resourcesPath + imageName);

        return img.getScaledInstance(scaleX, scaleY, Image.SCALE_SMOOTH);
    }
    
    private BufferedImage getBufferedImage(String imagePath) {
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(imagePath);

            return ImageIO.read(resourceAsStream);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load image ", e);
            System.exit(-1);
        }
        return null;
    }

    public void setGraphics(Graphics g) {
        graphics = g;
    }

    abstract protected String getFileName();
}
