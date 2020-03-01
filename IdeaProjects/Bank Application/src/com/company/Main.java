package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static void showMenu(){
        System.out.println("1 - Create a new branch");
        System.out.println("2 - Create a new customer");
        System.out.println("3 - Add a transaction to a customer");
        System.out.println("4 - Show branch customer list");
        System.out.println("5 - Show customer information and transactions");
        System.out.println("6 - Quit");
    }
    public static void main(String[] args) {
        Bank bank = new Bank("BBVA");
        int option;
        String branchName, customerName;
        int transaction;
        String showTrans;

        bank.addBranch("Regular");
        bank.addCustomer("Regular", "Gaston Monzon", 1258.6);
        bank.addCustomer("Regular", "Enzo Ferrari", 1485.6);
        bank.addCustomer("Regular", "Mugello", 4008.0);
        bank.addCustomer("Regular", "Tartari", 1200.0);
        bank.addBranch("Silver");
        bank.addCustomer("Silver", "Forza", 1500.0);
        bank.addCustomer("Silver", "Crespo", 528.0);
        bank.addBranch("Gold");
        bank.addCustomer("Gold", "Monarca", 1800.0);
        bank.addBranch("Platinum");
        bank.addCustomer("Platinum", "Sergio", 456.0);
        bank.addBranch("Black");
        bank.addCustomer("Black", "Monte", 87946.0);
        bank.addCustomer("Black", "Alto", 9841.3);
        bank.addCustomer("Black", "Maca", 86846.0);
        bank.addTransaction("Regular", "Gaston Monzon", 6412.0);
        bank.addTransaction("Regular", "Enzo Ferrari", 462.2);
        bank.addTransaction("Regular", "Mugello", 700.0);

        do {
            showMenu();
            option=s.nextInt();
            s.nextLine();

            switch (option){
                case 1:
                    System.out.println("Enter new branch name");
                    if(bank.addBranch(s.nextLine())){
                        System.out.println("Branch created");
                    }else
                        System.out.println("Branch already exists");
                    break;
                case 2:
                    System.out.println("Enter branch name");
                    branchName=s.nextLine();
                    if(bank.searchBranch(branchName)==null){
                        System.out.println("Branch not found");
                    }else {
                        System.out.println("Enter customer name");
                        customerName = s.nextLine();
                        System.out.println("Enter initial transaction");
                        transaction=s.nextInt();
                        if(bank.addCustomer(branchName, customerName, transaction)){
                            bank.addCustomer(branchName, customerName, transaction);
                            System.out.println("Customer " + customerName + " added to branch " + branchName);
                        }else{
                            System.out.println("Customer already exists");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter branch name");
                    branchName=s.nextLine();
                    if(bank.searchBranch(branchName)==null){
                        System.out.println("Branch not found");
                    }else {
                        System.out.println("Enter customer name");
                        customerName = s.nextLine();
                        if (bank.searchBranch(branchName).searchCustomer(customerName) != null) {
                            System.out.println("Enter transaction");
                            transaction = s.nextInt();
                            if (bank.addTransaction(branchName, customerName, transaction)) {
                                System.out.println("Transaction added to " + customerName);
                            } else {
                                System.out.println("Customer not found");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter branch name");
                    branchName=s.nextLine();
                    if(bank.searchBranch(branchName)==null){
                        System.out.println("Branch not found");
                    }else {
                        System.out.println("Enter 'y' to show transaction or any key to not");
                        showTrans=s.nextLine();
                        if (showTrans.equals("y") || showTrans.equals("Y")) {
                            bank.showCustomers(branchName, true);
                        } else{
                            bank.showCustomers(branchName, false);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Enter branch name");
                    branchName=s.nextLine();
                    if(bank.searchBranch(branchName)==null){
                        System.out.println("Branch not found");
                    }else {
                        System.out.println("Enter customer name");
                        customerName = s.nextLine();
                        if(bank.showCustomerInfo(branchName, customerName)){
                            System.out.println();
                        }else{
                            System.out.println("Customer not found");
                        }
                    }
                    break;
            }
        }while (option!=6);
    }
}
