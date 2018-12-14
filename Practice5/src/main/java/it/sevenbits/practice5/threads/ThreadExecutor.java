package it.sevenbits.practice5.threads;

import it.sevenbits.practice5.Account;

public class ThreadExecutor {

    public void showAccountFilling(long millis) throws InterruptedException {
        Account account = new Account(0);
        int threadsNumber = 3;

        Thread[] threads = new Thread[3];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new AccountThread(i + 1, account);
        }
        for (Thread current : threads) {
            current.start();
        }
        Thread.sleep(millis);
        for (Thread current : threads) {
            current.interrupt();
        }
        for (Thread current : threads) {
            current.join();
        }

        System.out.println(account.toString());
    }
}



