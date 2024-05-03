package pl.mazurek.entity;

public class Car {

    public int x;
    public int y;
    public final int startX;
    public final int startY;

    private final Direction startPosition;
    private final Direction direction;
    private boolean isMoving;


    public Car(int startX, int startY, Direction startPosition, Direction direction) {
        this.startX = startX;
        this.startY = startY;
        x = startX;
        y = startY;
        this.startPosition = startPosition;
        this.direction = direction;
        isMoving = false;
    }

    public Direction getStartPosition() {
        return startPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }
}
