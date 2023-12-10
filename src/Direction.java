public enum Direction {
    LEFT,
    RIGHT;


    public Direction getOppositeHorizontalDirection() {
        switch (this) {
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                return this;
        }
    }

}