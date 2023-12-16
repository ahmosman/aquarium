package aquarium;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

abstract public class Fish extends Resource {

    protected Direction direction;
    protected double startX;
    protected double startY;
    public static int WIDTH = 200;
    public static int HEIGHT = 100;

    public Fish() {
        super(WIDTH, HEIGHT);
        setRandomDirection();
        setRandomStartPosition();
        setImageDirection();
    }

    protected void setRandomStartPosition() {
        startX = Math.random() * AquariumApp.appWidth - (double) AquariumApp.appWidth / 2;
        startY = Math.random() * AquariumApp.appHeight - (double) AquariumApp.appHeight / 2;
    }

    public void setStartPosition(double x, double y) {
        startX = x;
        startY = y;
    }
    protected void setRandomDirection() {

        direction = (Math.random() > 0.5) ? Direction.RIGHT : Direction.LEFT;
    }

    protected void setImageDirection() {
        if (direction == getOriginalPictureDirection()) {
            imageView.setScaleX(1);
        } else {
            imageView.setScaleX(-1);
        }
    }

    public void changeDirection() {
        direction = direction.getOppositeHorizontalDirection();
        setImageDirection();
    }

    public void add() {
        AquariumApp.stackPane.getChildren().add(imageView);
        imageView.setTranslateX(startX);
        imageView.setTranslateY(startY);
        FishAnimation fishAnimation = new FishAnimation(this);
        fishAnimation.init();
    }

    abstract public int getSpeed();

    abstract protected Direction getOriginalPictureDirection();
}