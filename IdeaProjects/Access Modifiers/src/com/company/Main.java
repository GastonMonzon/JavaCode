package com.company;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("My Account");

        account.deposit(158.48);
        account.deposit(154.5);
        account.deposit(1254.62);
        account.deposit(48.1);
        account.deposit(52.3);
        account.withdrawl(123.6);
        account.withdrawl(141.1);
        account.withdrawl(489.2);
        account.withdrawl(546);
        account.withdrawl(158.2);
        account.calculateBalance();
    }
}
