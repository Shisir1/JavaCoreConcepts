package org.example;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Create the Account and Transaction classes here.
 */
class Account {
    private int balance;
    public Account(){
        this.balance = 0;
    }

    public synchronized String deposit(int money){
        this.balance += money;
        return "Depositing $"+money;
    }

    public synchronized String withdraw(int money){
        if(money > this.balance){
            return "Withdrawing $"+money +" (Insufficient Balance)";
        }else{
            this.balance -= money;
            return "Withdrawing $"+money;
        }
    }

    public int getBalance(){
        return this.balance;
    }
}

class Transaction{
    private Account account;
    private List<String> transactions;

    public Transaction(Account account){
        this.account  = account;
        this.transactions = new ArrayList<>();
    }

    public synchronized void deposit(int money){
        String transactionMessage = account.deposit(money);
        transactions.add(transactionMessage);
    }

    public synchronized void withdraw(int money){
        String transactionMessage = account.withdraw(money);
        transactions.add(transactionMessage);
    }

    public List<String> getTransaction(){
        return transactions;
    }
}

class TransactionRunnable implements Runnable {
    private static final SecureRandom RANDOM_GENERATOR = new SecureRandom();
    private final Transaction transaction;
    private final int transactionsCount;

    public TransactionRunnable(Transaction transaction, int transactionsCount) {
        this.transaction = transaction;
        this.transactionsCount = transactionsCount;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.transactionsCount; i++) {
            int transactionType = RANDOM_GENERATOR.nextInt() % 2;
            int money = RANDOM_GENERATOR.nextInt(100) + 1;

            if (transactionType == 0) {
                this.transaction.deposit(money);
            } else {
                this.transaction.withdraw(money);
            }
        }
    }
}

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Account ACCOUNT = new Account();
    private static final Transaction TRANSACTION = new Transaction(ACCOUNT);

    public static void main(String[] args) throws InterruptedException {
        int threadsCount = Integer.parseInt(SCANNER.nextLine());
        Thread[] threads = new Thread[threadsCount];

        int expectedTransactionsCount = 0;
        for (int i = 0; i < threadsCount; i++) {
            int transactionsCount = Integer.parseInt(SCANNER.nextLine());
            expectedTransactionsCount += transactionsCount;

            threads[i] = new Thread(new TransactionRunnable(TRANSACTION, transactionsCount));
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threadsCount; i++) {
            threads[i].join();
        }

        List<String> transactions = TRANSACTION.getTransaction();

        if (transactions.size() != expectedTransactionsCount) {
            System.out.println("Wrong Answer");
        } else {
            boolean correct = true;
            for (String transaction : transactions) {
                if (transaction == null) {
                    correct = false;

                    break;
                }
            }

            if (!correct) {
                System.out.println("Wrong Answer");
            } else {
                int balance = ACCOUNT.getBalance();
            }
        }
    }
}