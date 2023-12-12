package aquarium;

public class GreyFish extends Fish{
    public GreyFish() {
        super();
    }

    public int getSpeed() {
        return 100;
    }

    protected String getFileName() {
        return "fish-grey.png";
    }

    protected Direction getOriginalPictureDirection() {
        return Direction.LEFT;
    }
}
