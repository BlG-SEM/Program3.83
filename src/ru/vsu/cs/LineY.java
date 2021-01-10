package ru.vsu.cs;

public class LineY {
    public double y;

    public LineY(double y) {
        this.y = y;
    }

    public boolean isPointInside(Point point) {
        return point.getY() > y;
    }
}