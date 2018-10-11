package main.it.sevenbits;

public class Line {

    private Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public double getLength(){
        return Math.sqrt(Math.pow((end.getX() - start.getX()), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
