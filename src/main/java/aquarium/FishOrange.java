package aquarium;

public class FishOrange extends Fish {
    public FishOrange() {
        super();
    }

    public int getSpeed() {
        return 50;
    }

    protected String getFileName() {
        return "fish-orange.png";
    }

    protected Direction getOriginalPictureDirection() {
        return Direction.RIGHT;
    }
}
