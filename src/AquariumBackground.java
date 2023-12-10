import java.awt.*;

public class AquariumBackground extends Resource {

    public void showBackground() {

        graphics.drawImage(getImage(getFileName(), AquariumApp.appWidth, AquariumApp.appHeight), 0, 0, null);
    }

    public String getFileName() {
        return "aquarium.jpg";
    }
}
