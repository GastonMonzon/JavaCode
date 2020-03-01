package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public void showContacts(){
        System.out.println("There are " + this.myContacts.size() + " contacts");
        for(int i=0; i<this.myContacts.size(); i++){
            System.out.println(i+1 + " " + this.myContacts.get(i).getName() + " " + this.myContacts.get(i).getNumber());
        }
    }
    public boolean addContact(Contacts contact){
        if(searchContact(contact.getName())!=-1){
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }
    }

    public int searchContact(Contacts contact){
        return myContacts.indexOf(contact);
    }

    public int searchContact(String name){
        for(int i=0; i<myContacts.size(); i++){
            if(this.myContacts.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public Contacts queryContact(String name){
        if(searchContact(name)!=-1){
            return this.myContacts.get(searchContact(name));
        }
        return null;
    }

    public void modifyContact(Contacts oldContact, Contacts newContact){
        if(searchContact(oldContact)!=-1) {
            System.out.println(oldContact.getName() + " replaced with " + newContact.getName());
            myContacts.set(searchContact(oldContact), newContact);
        }else{
            System.out.println("Contact not found");
        }
    }

    public void removeContact(Contacts contact){
        if(searchContact(contact)!=-1){
            System.out.println(contact.getName() + " removed");
            myContacts.remove(contact);
        }
    }
}
