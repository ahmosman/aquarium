package aquarium;

public class FishGreen extends Fish {
    @Override
    public int getSpeed() {
        return 100;
    }

    @Override
    protected Direction getOriginalPictureDirection() {
        return Direction.LEFT;
    }

    @Override
    protected String getFileName() {
        return "fish-green.png";
    }
}
