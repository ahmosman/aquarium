package aquarium;

public class FishPrawn extends Fish {

    @Override
    public int getSpeed() {
        return 70;
    }

    @Override
    protected Direction getOriginalPictureDirection() {
        return Direction.RIGHT;
    }

    @Override
    protected String getFileName() {
        return "fish-prawn.png";
    }
}
