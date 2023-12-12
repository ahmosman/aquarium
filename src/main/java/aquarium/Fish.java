package aquarium;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

abstract public class Fish extends Resource {

    protected Direction direction;
    protected double startX;
    protected double startY;
    protected TranslateTransition transition;

    public static int WIDTH = 200;
    public static int HEIGHT = 100;

    public static int MIN_DURATION = 5;
    public static int MAX_DURATION = 30;

    public Fish() {
        super(WIDTH, HEIGHT);
        setRandomDirection();
        setRandomStartPosition();
        initAnimation();
        setImageDirection();
        setClickEvent();
    }

    protected void setRandomStartPosition() {
        startX = Math.random() * AquariumApp.appWidth - (double) AquariumApp.appWidth / 2;
        startY = Math.random() * AquariumApp.appHeight - (double) AquariumApp.appHeight / 2;
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

    protected void initAnimation() {
        transition = new TranslateTransition(Duration.seconds(calcDuration()), imageView);
        transition.setOnFinished(event -> {
            handleFinishedAnimation();
        });
        imageView.setTranslateX(startX);
        imageView.setTranslateY(startY);
    }

    protected void handleFinishedAnimation() {
        changeDirection();
        animate();
    }

    protected void changeDirection() {
        direction = direction.getOppositeHorizontalDirection();
        setImageDirection();
    }

    protected double getDestinationX() {
        return (direction == Direction.RIGHT) ? AquariumApp.appWidth : - AquariumApp.appWidth;
    }
    public void animate() {
        transition.setFromX(imageView.getTranslateX());
        transition.setFromY(imageView.getTranslateY());
        transition.setToX(getDestinationX());
        transition.play();
    }

    public void add() {
        AquariumApp.stackPane.getChildren().add(imageView);
    }

    protected double calcDuration() {
        int speed = getSpeed();

        // Define the speed thresholds for the percentage calculation
        int minSpeed = 1;
        int maxSpeed = 100;

        if (speed < minSpeed) {
            speed = minSpeed;
        } else if (speed > maxSpeed) {
            speed = maxSpeed;
        }

        double calc = MIN_DURATION + ((MAX_DURATION - MIN_DURATION) * ((100 - speed) * 0.01));
        System.out.println("calc: " + calc);

        return calc;
    }

    protected void setClickEvent() {
        imageView.setOnMouseClicked(event -> {
            transition.pause();
            changeDirection();
            startX = imageView.getTranslateX();
            startY = imageView.getTranslateY();
            animate();

        });
    }
    abstract public int getSpeed();

    abstract protected Direction getOriginalPictureDirection();
}