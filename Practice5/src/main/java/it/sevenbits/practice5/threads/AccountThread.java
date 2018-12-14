package it.sevenbits.practice5.threads;

import it.sevenbits.practice5.Account;

public class AccountThread extends Thread implements Runnable {
    private int value;
    private final Account account;

    public AccountThread(final int value, final Account account) {
        this.value = value;
        this.account = account;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        while (!Thread.interrupted()) {
            synchronized (account) {
                try {
                    account.addToBalance(value);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " interrupted");
    }
}