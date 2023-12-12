package aquarium;

public class OrangeFish extends Fish {
    public OrangeFish() {
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
