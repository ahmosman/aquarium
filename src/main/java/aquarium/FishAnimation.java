package aquarium;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

public class FishAnimation {
    protected Fish fish;
    protected TranslateTransition transition;

    public static int MIN_DURATION = 2;
    public static int MAX_DURATION = 20;

    public FishAnimation(Fish fish) {
        this.fish = fish;
    }
    public void init() {
        setTransition();
        setClickEvent();
        animate();
    }
    protected void setTransition() {
        transition = new TranslateTransition(Duration.seconds(calcDuration()), fish.imageView);
        transition.setOnFinished(event -> {
            handleFinishedAnimation();
        });
    }

    protected void handleFinishedAnimation() {
        fish.changeDirection();
        animate();
    }

    protected void animate() {
        transition.setFromX(fish.imageView.getTranslateX());
        transition.setFromY(fish.imageView.getTranslateY());
        transition.setToX(getDestinationX());
        transition.play();
    }

    protected double getDestinationX() {
        int directionModifier = (fish.direction == Direction.RIGHT) ? 1 : -1;
        return ((double) (directionModifier * (AquariumApp.appWidth - Fish.WIDTH)) / 2);
    }

    protected double calcDuration() {
        int speed = fish.getSpeed();

        // Define the speed thresholds for the percentage calculation
        int minSpeed = 1;
        int maxSpeed = 100;

        if (speed < minSpeed) {
            speed = minSpeed;
        } else if (speed > maxSpeed) {
            speed = maxSpeed;
        }

        return MIN_DURATION + ((MAX_DURATION - MIN_DURATION) * ((100 - speed) * 0.01));
    }

    protected void setClickEvent() {
        fish.imageView.setOnMouseClicked(event -> {
            transition.stop();
            fish.changeDirection();
            animate();
            event.consume();
        });
    }
}
