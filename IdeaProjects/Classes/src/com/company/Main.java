package com.company;

import java.util.Scanner;

class VIpCustomer{
    private String name;
    private double creditLimit;
    private String emailAddress;

    public VIpCustomer(){
        this("Ahoy", 999999, "geremias@gmail.com");
    }

    public VIpCustomer(String name, double creditLimit) {
        this(name, creditLimit, "geremias@gmail.com");
    }

    public VIpCustomer(String name, double creditLimit, String emailAddress){
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName(){
        return name;
    }
    public double getCreditLimit(){
        return creditLimit;
    }

    public String getEmailAddress(){
        return emailAddress;
    }
}

class Fijate{
    private int algo;

    public Fijate(int algo){
        this.algo = algo;
    }

    public int getAlgo(){
        return algo;
    }

    public void hacer(String Q, int esto){
        for(int i=0; i<esto; i++){
            System.out.println(Q);
        }
    }
}

class FijateEsto extends Fijate{
    private String mas;

    public FijateEsto(int algo, String mas){
        super(algo);
        this.mas = mas;
    }

    public String getMas(){
        return mas;
    }

    @Override
    public void hacer(String Q, int esto) {
        for(int j=0; j<esto-3; j++){
            System.out.println("EJE");
        }
//        super.hacer(Q, esto);
    }
}

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();
    public static void showOptions(){
        System.out.println("1 = Show grocery list/n");
        System.out.println("2 = Add item");
        System.out.println("3 = Search item");
        System.out.println("4 = Modify Item");
        System.out.println("5 = remove item");
        System.out.println("6 = Quit");
    }
    public static void main(String[] args) {
        int option;
        do{
            showOptions();
            option=scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    groceryList.showList();
                    break;
                case 2:
                    System.out.println("Enter the item to add");
                    groceryList.addItem(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("Enter the item to search");
                    groceryList.searchItem(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Enter item number to modify");
                    int itemPosition = scanner.nextInt();
                    System.out.println("Enter replacement item");
                    String item = scanner.nextLine();
                    groceryList.modifyItem(itemPosition, item);
                    break;
                case 5:
                    System.out.println("Enter item number to remove");
                    int itemPosition2 = scanner.nextInt();
                    groceryList.removeItem(itemPosition2);
                    break;
            }
        }while(option!=6);



//        FijateEsto Aver = new FijateEsto(8, "Jamaica");
//        Aver.hacer("Aja", 8);
//        VIpCustomer ME = new VIpCustomer();
//        System.out.println(ME.getName() + " "+  ME.getCreditLimit() + " " + ME.getEmailAddress());
//        VIpCustomer You = new VIpCustomer("Jasinto", 15552.5, "ajajaj@gmail.com");
//        System.out.println(You.getName() + " " + You.getCreditLimit() + " " + You.getEmailAddress());
//        VIpCustomer eeeh = new VIpCustomer("ALALAL", 188452.58);
//        System.out.println(eeeh.getName() + " " + eeeh.getCreditLimit() + " " + eeeh.getEmailAddress());
    }
}
