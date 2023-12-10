public class OrangeFish extends Fish {

    protected String getFileName() {
        return "fish-orange.png";
    }

    public int getSpeed() {
        return 50;
    }

    protected Direction getOriginalPictureDirection() {
        return Direction.RIGHT;
    }
}
