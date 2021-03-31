package colorsGame;

public abstract class Coordinates {

    private int x;
    private int y;


    protected Coordinates(int x, int y) {

        this.x = x;
        this.y = y;
    }

    protected int getX() {
        return x;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected int getY() {
        return y;
    }

    protected void setY(int y) {
        this.y = y;
    }
}
