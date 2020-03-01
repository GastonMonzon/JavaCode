package com.company;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branches> branch;

    public Bank(String name) {
        this.name = name;
        this.branch = new ArrayList<>();
    }

    public ArrayList<Branches> getMyBranches() {
        return branch;
    }

    public boolean addBranch(String name){
        if(searchBranch(name)==null){
            this.branch.add(new Branches(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction){
        Branches branch = searchBranch(branchName);
        if(branch!=null){
            return branch.addCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transaction){
        Branches branch = searchBranch(branchName);
        if(branch!=null){
            return branch.addTransaction(customerName, transaction);
        }
        return false;
    }

    public Branches searchBranch(String name){
        for (Branches branch : this.branch) {
            if (branch.getName().equals(name)) {
                return branch;
            }
        }
        return null;
    }

    public void showCustomers(String branchName, boolean showTransactions){
        Branches branch = searchBranch(branchName);
        if(branch!=null){
            System.out.println("Customers for branch " + branch.getName());
            ArrayList<Customers> branchCustomer=branch.getMyCustomers();
            for(int i=0; i<branchCustomer.size(); i++){
                Customers customer=branchCustomer.get(i);
                System.out.println(i+1 + " " + customer.getCustomerName());
                if(showTransactions){
                    ArrayList<Double> transactions=customer.getTransactions();
                    System.out.println("Transactions");
                    for(int j=0; j<transactions.size(); j++){
                        System.out.println(j+1 + " " + transactions.get(j));
                    }
                }
            }
        }
    }

    public boolean showCustomerInfo(String branchName, String customerName){
            if(searchBranch(branchName).searchCustomer(customerName)!=null){
                Customers customer = searchBranch(branchName).searchCustomer(customerName);
                System.out.println("Customer info\n" + customer.getCustomerName());
                System.out.println("Transactions");
                for(int i=0; i<customer.getTransactions().size(); i++){
                    System.out.println(i+1 + " " + customer.getTransactions().get(i));
                }
                return true;
            }
            return false;
        }
}
