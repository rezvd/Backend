package it.sevenbits.practice5;

import it.sevenbits.practice5.threads.ThreadExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int number = 10;
        final int max = 30;
        final int start = 3;
        final int end = 7;
        final int replaceFirst = 8;
        final int replaceSecond = 2;

//        //FIRST task, part one
//        System.out.println("    Example of ListOperator with ArrayList<Integer>");
//        ListOperator listOperator = new ListOperator();
//        List<Integer> listInt = new ArrayList<Integer>(number);
//        //filling a list
//        Random random = new Random();
//        for (int i = 0; i < number; i++) {
//            listInt.add(random.nextInt(max));
//            System.out.print(listInt.get(i) + " ");
//        }
//        //searching max
//        System.out.println("\nMax from " + (start + 1) + " to " + (end + 1) + " = " + listOperator.max(listInt, start, end));
//        //replacing
//        listOperator.changeElementsPosition(listInt, replaceFirst, replaceSecond);
//        System.out.println("After replacing " + (replaceFirst + 1) + " with " + (replaceSecond + 1));
//        for (Integer current : listInt) {
//            System.out.print(current + " ");
//        }
//
//        //FIRST task, part two
//        System.out.println("\n\n    Example of ListOperator with ArrayList<Account>");
//        List<Account> listAccount = new LinkedList<Account>();
//        //filling
//        for (int i = 0; i < number; i++) {
//            listAccount.add(new Account(random.nextInt(max)));
//            System.out.println(listAccount.get(i));
//        }
//        //searching max
//        System.out.println("\nMax from " + (start + 1) + " to " + (end + 1) + " is " + listOperator.max(listAccount, start, end));
//        //replacing
//        listOperator.changeElementsPosition(listAccount, replaceFirst, replaceSecond);
//        System.out.println("After replacing " + (replaceFirst + 1) + " with " + (replaceSecond + 1));
//        for (Account current : listAccount) {
//            System.out.println(current);
//        }


//        SECOND task
        System.out.println("\n\n    Practice with multithreading");
        ThreadExecutor threadExecutor = new ThreadExecutor();
        threadExecutor.showAccountFilling(500);
    }
}
