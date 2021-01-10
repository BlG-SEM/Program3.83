package ru.vsu.cs;

public class Picture {
    private final Parabola parabola;
    private final Circle circle;
    private final Line line1;
    private final Line line2;
    private final LineY line3;

    public Picture(Parabola parabola, Circle circle, Line line1, Line line2, LineY line3) {
        this.parabola = parabola;
        this.circle = circle;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }

    public SimpleColor getColor(Point point) {

        if (circle.isPointInside(point) && parabola.isPointInside(point)) {
            return SimpleColor.ORANGE;
        }
        if (circle.isPointInside(point)) {
            return SimpleColor.YELLOW;
        }
        if (parabola.isPointInside(point) && !line1.isPointInside(point) && line2.isPointInside(point)) {
            return SimpleColor.ORANGE;
        }
        if (parabola.isPointInside(point) && line2.isPointInside(point)) {
            return SimpleColor.GREY;
        }
        if (parabola.isPointInside(point) && !line1.isPointInside(point)) {
            return SimpleColor.GREEN;
        }
        if (!line1.isPointInside(point) && !line3.isPointInside(point)) {
            return SimpleColor.GREEN;
        }
        if (!line3.isPointInside(point)) {
            return SimpleColor.GREY;
        }
        if (line1.isPointInside(point) && !line2.isPointInside(point) && line3.isPointInside(point)) {
            return SimpleColor.WHITE;
        }
        if (!line1.isPointInside(point) && line2.isPointInside(point) ) {
            return SimpleColor.YELLOW;
        }
        return SimpleColor.BLUE;
    }
}