package summatra;

import summatra.array.ArraySummaterException;
import summatra.array.IArraySummater;
import summatra.array.PairSummater;

import java.util.Random;

/**
 * summatra.Main class in summatra project. Created for demonstration interface IArraySummater
 */
 public final class Main {

    /**
     * Constructor, which will never be called. Utility lass should not be public
     */
    private Main(){}

    /**
     * summatra.Main method in summatra.Main class. Demonstrates work with interface IArraySummater
     * @param args Array of strings, which can be given as parametres for programm
     */
    public static void main(final String[] args) {
        IArraySummater summater = new PairSummater();
        final int MAX_LENGTH = 6;
        final int MAX_VALUE = 50;
        Random r = new Random();
        int[] toSum = new int[MAX_LENGTH];
        for (int i = 0; i < toSum.length; i++) {
            toSum[i] = r.nextInt(MAX_VALUE);
            System.out.print(toSum[i] + " ");
        }
        try {
            int sum = summater.sum(toSum);
            System.out.println("\nMax sum is " + sum);
        } catch (ArraySummaterException e) {
            e.printStackTrace();
        }


    }
}
