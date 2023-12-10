import java.awt.*;

public class FishCollection {
    private Fish[] fishCollection;
    private int fishCount;

    public FishCollection(int maxFish) {
        fishCollection = new Fish[maxFish];
        fishCount = 0;
    }

    public void add(Fish fish) {
        fishCollection[fishCount] = fish;
        fishCount++;
    }

    public void drawAll(Graphics graphics) {
        for (int i = 0; i < fishCount; i++) {
            fishCollection[i].setGraphics(graphics);
            fishCollection[i].draw();
        }
    }

    public void moveAll() {
        for (int i = 0; i < fishCount; i++) {
            fishCollection[i].move();
        }
    }

    public void changeDirections(int x, int y) {
        for (int i = 0; i < fishCount; i++) {

            if (fishCollection[i].postitionX < x && x < fishCollection[i].postitionX + Fish.FISH_WIDTH
                    && fishCollection[i].postitionY < y && y < fishCollection[i].postitionY + Fish.FISH_HEIGHT) {
                fishCollection[i].direction = fishCollection[i].direction.getOppositeHorizontalDirection();
            }
        }
    }
}
