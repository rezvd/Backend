package main.it.sevenbits;

import java.util.Random;

public class Main {

    public static void main(String[] arg) {
        Line[] lines = new Line[5];
        Random r = new Random();
        double max = Double.MIN_VALUE;

        for(int i = 0; i < 5; ++i) {
            int startX = r.nextInt(100) - 50;
            int startY = r.nextInt(100) - 50;
            int endX = r.nextInt(100) - 50;
            int endY = r.nextInt(100) - 50;
            lines[i] = new Line(new Point(startX, startY), new Point(endX, endY));
            if (lines[i].getLength() > max){
                max = lines[i].getLength();
            }
            System.out.println("Line " + (i + 1) + ": start(" + startX + ", " + startY + "), end(" + endX + ", " + endY + ");");
            System.out.println("Length of this line is " + lines[i].getLength());
        }
        System.out.println("The biggest length is " + max);

    }
}