package it.sevenbits.practice5.threads;

import it.sevenbits.practice5.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountThread extends Thread implements Runnable {
    private int value;
    private final Account account;
    private Logger logger = LoggerFactory.getLogger(Account.class);

    public AccountThread(final int value, final Account account) {
        this.value = value;
        this.account = account;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            while (!Thread.interrupted()) {
                synchronized (account) {
                    account.addToBalance(value);
                }
            }
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("Interrupted while sleeping");
            }
        }

        System.out.println(Thread.currentThread().getName() + " interrupted");
    }
}