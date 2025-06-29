package org.example.domain;

public class User {
    private final int userId;
    private int balance;

    public User(int userId, int balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public int getUserId() {
        return userId;
    }

    public int getBalance() {
        return balance;
    }

    public void deductBalance(int amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", balance=" + balance + '}';
    }
}

