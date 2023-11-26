import java.awt.*;

public class AquariumBackground extends Resource {

    private Image background;
    public void showBackground(Graphics g) {

        background = getImage("aquarium.jpg", AquariumApp.appWidth, AquariumApp.appHeight);
        g.drawImage(background, 0, 0, null);
    }

}
