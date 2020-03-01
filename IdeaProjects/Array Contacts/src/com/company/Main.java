package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static MobilePhone myPhone = new MobilePhone("1131449224");
    private static void showMenu(){
        System.out.println("1 - Show contacts");
        System.out.println("2 - Add contact");
        System.out.println("3 - Search contact");
        System.out.println("4 - Modify contact");
        System.out.println("5 - Remove contact");
        System.out.println("6 - Quit");
    }
    public static void main(String[] args) {
        int option;
        String name, number;
        do {
            showMenu();
            option=s.nextInt();
            s.nextLine();
            switch (option){
                case 1:
                    myPhone.showContacts();
                    break;
                case 2:
                    System.out.println("Enter contact name");
                    name=s.nextLine();
                    System.out.println("Enter contact number");
                    number=s.nextLine();
                    if(myPhone.addContact(Contacts.createContact(name, number))){
                        System.out.println("Contact added");
                    }
                    else
                        System.out.println("Contact already exists");
                    break;
                case 3:
                    System.out.println("Enter contact name to search");
                    name=s.nextLine();
                    if(myPhone.searchContact(name)!=-1){
                        System.out.println("Contact found\nname: " + myPhone.queryContact(name).getName() + " number: " + myPhone.queryContact(name).getNumber());
                    }else{
                        System.out.println("Contact not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter contact name to modify");
                    name=s.nextLine();
                    if(myPhone.searchContact(name)!=-1){
                        Contacts oldContact = myPhone.queryContact(name);
                        System.out.println("Enter contact name replacement");
                        name=s.nextLine();
                        System.out.println("Enter contact number");
                        number=s.nextLine();
                        if(myPhone.searchContact(oldContact.getName())!=-1) {
                            myPhone.modifyContact(oldContact, Contacts.createContact(name, number));
                            System.out.println("Contact modified");
                        }
                        else
                            System.out.println("Contact already exists");
                    }else{
                        System.out.println("Contact not found");
                    }
                    break;
                case 5:
                    System.out.println("Enter contact name to remove");
                    name=s.nextLine();
                    if(myPhone.queryContact(name)!=null){
                        myPhone.removeContact(myPhone.queryContact(name));
                    }else{
                        System.out.println("Contact not found");
                    }
                    break;
            }
        }while(option!=6);
    }
}
