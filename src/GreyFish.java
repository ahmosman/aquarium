public class GreyFish extends Fish {
    protected String getFileName() {
        return "fish-grey.png";
    }

    public int getSpeed() {
        return 100;
    }

    protected Direction getOriginalPictureDirection() {
        return Direction.LEFT;
    }
}
