package com.company;

import java.util.ArrayList;

public class Branches {
    private String name;
    private ArrayList<Customers> customer;

    public Branches(String name){
        this.name = name;
        this.customer = new ArrayList<>();
    }

    public ArrayList<Customers> getMyCustomers() {
        return customer;
    }

    public String getName() {
        return name;
    }

    public boolean addCustomer(String customerName, double InitialAmount){
        if(searchCustomer(customerName)==null){
            this.customer.add(new Customers(customerName, InitialAmount));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double transaction){

        Customers existingCustomer = searchCustomer(customerName);
        if(existingCustomer!=null){
            existingCustomer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    public Customers searchCustomer(String name){
        for(int i=0; i<customer.size(); i++){
            Customers checkedCustomer = this.customer.get(i);
            if(checkedCustomer.getCustomerName().equals(name)){
                return checkedCustomer;
            }
        }
        return null;
    }
}
