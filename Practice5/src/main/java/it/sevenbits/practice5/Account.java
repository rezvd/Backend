package it.sevenbits.practice5;

import java.util.UUID;

public class Account implements Comparable<Account>{
    private String id;
    private long balance;

    public Account(long balance) {
        id = UUID.randomUUID().toString();
        this.balance = balance;
    }

    public void addToBalance(long value) throws Exception {
        long balance = this.balance;
        Thread.sleep(1);
        this.balance = balance + value;
    }

    public long getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Account id: %s with balance %s", id, balance);
    }

    public int compareTo(Account account) {
        if (this.balance > account.balance) {
            return 1;
        } else {
            if (this.balance < account.balance) {
                return -1;
            } else return 0;
        }
    }
}