package aquarium;

public class FishGrey extends Fish{
    public FishGrey() {
        super();
    }

    public int getSpeed() {
        return 80;
    }

    protected String getFileName() {
        return "fish-grey.png";
    }

    protected Direction getOriginalPictureDirection() {
        return Direction.LEFT;
    }
}
