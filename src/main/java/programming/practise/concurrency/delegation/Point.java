package programming.practise.concurrency.delegation;

public class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
