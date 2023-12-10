import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

abstract public class Fish extends Resource {

    public static final int FISH_WIDTH = 200;
    public static final int FISH_HEIGHT = 100;
    public int postitionX;
    public int postitionY;
    public Direction direction;
    public Fish() {
        setRandomPosition();
        setRandomDirection();
    }

    public void setRandomDirection() {
        direction = (Math.random() > 0.5) ? Direction.RIGHT : Direction.LEFT;
    }
    public void setRandomPosition() {
        postitionX = (int) (Math.random() * AquariumApp.appWidth);
        postitionY = (int) (Math.random() * AquariumApp.appHeight);
    }
    public void draw() {

        if (direction == getOriginalPictureDirection()) {
            System.out.println("original");
            drawOriginalImage();
        } else {
            System.out.println("reverse");

            drawReverseImage();
        }
    }

    protected void drawReverseImage() {
        Image image = getImage(getFileName(), FISH_WIDTH, FISH_HEIGHT);
        graphics.drawImage(image, postitionX + FISH_WIDTH, postitionY, -FISH_WIDTH, FISH_HEIGHT, null);
    }

    protected void drawOriginalImage() {
        Image image = getImage(getFileName(), FISH_WIDTH, FISH_HEIGHT);
        graphics.drawImage(image, postitionX, postitionY, FISH_WIDTH, FISH_HEIGHT, null);
    }

    abstract protected String getFileName();

    abstract  public int getSpeed();

    public void move() {
        if (direction == Direction.RIGHT) {
            postitionX += getSpeed();
        } else {
            postitionX -= getSpeed();
        }

        //if fish out of screen then move to other side
        if (postitionX > AquariumApp.appWidth + FISH_WIDTH) {
            postitionX = -FISH_WIDTH;
        } else if (postitionX < -FISH_WIDTH) {
            postitionX = AquariumApp.appWidth + FISH_WIDTH;
        }
    }

    public boolean isClicked(int mouseX, int mouseY) {
        return mouseX >= postitionX && mouseX <= postitionX + 200 &&
                mouseY >= postitionY && mouseY <= postitionY + 100;
    }

    public void changeDirection() {
        direction = direction.getOppositeHorizontalDirection();
        //change picture direction

    }

    abstract protected Direction getOriginalPictureDirection();
}
