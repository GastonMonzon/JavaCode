package com.company;

import java.util.ArrayList;

public class Account implements Accessible{
    private String accountName;
    private double balance =0;
    private ArrayList<Double> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public void methodA() {
        int a = SOME_CONSTANT;
    }

    @Override
    public void methodB() {

    }

    @Override
    public boolean methodC() {
        return false;
    }

    public void deposit(double amount){
        if(amount>0){
            transactions.add(amount);
            this.balance+=amount;
            System.out.println(amount + " deposited. Balance now is: " + this.balance);
        }else{
            System.out.println("Cannot deposit negative amounts");
        }
    }

    public void withdrawl(double amount){
        double withdrawl = -amount;
        if(withdrawl<0){
            this.transactions.add(withdrawl);
            this.balance+=withdrawl;
            System.out.println(withdrawl + " withddrawn. Balance now is: " + this.balance);
        }else{
            System.out.println("Cannot withdraw negative amounts");
        }
    }

    public void calculateBalance(){
        this.balance=0;
        for(double i : this.transactions){
            this.balance+=i;
        }
        System.out.println("Calculated balance is: " + this.balance);
    }
}
