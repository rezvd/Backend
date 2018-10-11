//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package main.it.sevenbits;

public class Line {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public double getLength() {
        return Math.sqrt(Math.pow((double)(this.end.getX() - this.start.getX()), 2.0D) + Math.pow((double)(this.end.getY() - this.start.getY()), 2.0D));
    }
}
