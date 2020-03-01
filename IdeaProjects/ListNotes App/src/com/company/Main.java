package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ListNotes listNotes = new ListNotes();
    private static UserName user;// Here they work well without creating problems
    private static List listClass;// inside the program many switches and loops

    public static void main(String[] args) {
        int option1, option2, option3, position, listNumber;
        String userName, newUserName, choice, listName, item, newItem;
        String[][] itemsFound;
        boolean addToList=false;

        listNotes.singIn("Gatuno");
        listNotes.singIn("Cleo");
        listNotes.singIn("Patra");
        listNotes.singIn("Neo");
        listNotes.singIn("Olga");
        user=listNotes.searchUsers("Gatuno");
        user.addList("Groceries");
        listClass =user.searchLists("Groceries");
        listClass.addItem("Bread");
        listClass.addItem("Spinach");
        listClass.addItem("Tomato");
        listClass.addItem("Garlic");
        listClass.addItem("Watermelon");
        listClass.addItem("Pineapple");
        listClass.addItem("Bananas");
        user.addList("Games");
        listClass =user.searchLists("Games");
        listClass.addItem("Halo 4");
        listClass.addItem("Storm");
        listClass.addItem("Heaven");
        listClass.addItem("Doom");
        listClass.addItem("Doom Eternal");
        listClass.addItem("Metro Exodus");
        listClass.addItem("Deadpool");
        listClass.addItem("Dips");
        user.addList("Exercises");
        listClass =user.searchLists("Exercises");
        listClass.addItem("Chin Ups");
        listClass.addItem("Dips");
        listClass.addItem("Barbell Curl");
        listClass.addItem("Shoulder Press");
        listClass.addItem("Bench Press");

        user=listNotes.searchUsers("Cleo");
        user.addList("Misc");
        listClass =user.searchLists("Misc");
        listClass.addItem("Why");
        listClass.addItem("I don't know");
        listClass.addItem("What");
        listClass.addItem("Nothing");
        listClass.addItem("Something");
        user.addList("Places");
        listClass =user.searchLists("Places");
        listClass.addItem("Argentina");
        listClass.addItem("Brasil");
        listClass.addItem("Jamaica");
        listClass.addItem("Nicaragua");

        user=listNotes.searchUsers("Patra");
        user.addList("Music");
        listClass =user.searchLists("Music");
        listClass.addItem("Yeah.1");
        listClass.addItem("My Lucifer");
        listClass.addItem("No");
        listClass.addItem("Wifi");
        listClass.addItem("Low");
        listClass.addItem("Hi");

        do {
            showMainMenu();
            do {
                option1 = s.nextInt();
                s.nextLine();
            }while(option1<1 || option1>3);
            switch (option1) {
                case 1:// Log in or create new user
                    System.out.println("Enter username");
                    userName = s.nextLine();
                    if (listNotes.searchUsers(userName) == null) {
                        System.out.println("Username doesn't exists. Create new username? Y or N");
                        choice = s.nextLine();
                        if (choice.equals("Y") || choice.equals("y")) {// Enters submenu
                            user = listNotes.singIn(userName);
                            System.out.println("New username " + userName + " created");
                        } else {
                            break;// Doesn't enter submenu
                        }
                    } else {// Enters submenu
                        user = listNotes.singIn(userName);
                        System.out.println("Username " + user.getName() + " log on");
                    }
                    do {
                        showListMenu();
                        do {
                            option2 = s.nextInt();
                            s.nextLine();
                        }while(option2<1 || option2>5);
                        switch (option2) {
                            case 1:// New List
                                System.out.println("Enter list name");
                                listName = s.nextLine();
                                user.addList(listName);
                                System.out.println("Add items to the list? Y or N");
                                choice=s.nextLine();
                                if (choice.equals("Y") || choice.equals("y")) {
                                    listClass = user.searchLists(listName);
                                    addToList=true;// Enters next option that's add to list
                                }else {
                                    break;
                                }
                                case 2:// Both cases together so adding items to new list
                                case 3:// jumps only once
                                    if(!addToList){ // Doesn't enter if adding to new list
                                        user.showListOfNotes();// Shows the list every time to select from it
                                        if(option2==2) {
                                    System.out.println("Enter list name");// Add to list by name
                                    listName=s.nextLine();
                                    listClass= user.searchLists(listName);
                                    if(listClass==null) {
                                        System.out.println("List not found ");
                                        break;
                                    }
                                        }else{
                                            System.out.println("Enter list number");// Add to list by number
                                            listNumber = s.nextInt();
                                            s.nextLine();
                                            if(listNumber<=user.getListOfLists().size()){
                                            listClass = user.getListOfLists().get(listNumber-1);
                                            }else{
                                                System.out.println("Invalid number");
                                                break;
                                            }
                                        }
                                    }
                                do {
                                    if(!addToList) {// Enters submenu
                                        listClass.showList();// Always shows the list to select from
                                        showItemMenu();
                                        do {
                                            option3 = s.nextInt();
                                            s.nextLine();
                                        }while(option3<1 || option3>6);
                                    }else{
                                        option3=1;// And goes to option 1
                                    }
                                        switch (option3) {
                                            case 1:// Add items
                                                do {
                                                    System.out.println("Enter item to add or 0 to exit");
                                                    item = s.nextLine();
                                                    if (!(item.equals("0"))) {
                                                        listClass.addItem(item);
                                                        System.out.println("Item " + item + " added to " + listClass.getName());
                                                    }
                                                }
                                                while (!(item.equals("0")));
                                                addToList = false;
                                                break;
                                            case 2:// Modify item
                                                System.out.println("Enter item number to modify");
                                                position = s.nextInt();
                                                s.nextLine();
                                                if (listClass.getList().get(position-1) != null) {
                                                    System.out.println("Enter new item");
                                                    newItem = s.nextLine();
                                                    listClass.modifyItem(position-1, newItem);
                                                }
                                                break;
                                            case 3:// Remove item
                                                System.out.println("Enter item number to remove");
                                                position=s.nextInt();
                                                s.nextLine();
                                                listClass.removeItem(position-1);
                                                break;
                                            case 4:// Sort by name increasingly
                                                Collections.sort(listClass.getList());
                                                break;
                                            case 5:// Sort by name decreasingly
//                                                Collections.sort(listClass.getList(), Comparator.reverseOrder());
                                                listClass.getList().sort(Comparator.reverseOrder());
                                        }
                                }while(option3!=6);
                                break;
                            case 4:// Searches item on all lists and shows their positions
                                System.out.println("Enter item to search");
                                item=s.nextLine();
                                itemsFound=user.searchItem(item);
                                if(!(itemsFound[0][0].isEmpty())){
                                    int i=0;
                                    System.out.println("Found item " + item + " on");
                                    while(itemsFound[i][0]!=null) {//Using an ArrayList
                                        System.out.println(itemsFound[i][0] + " list");
                                        System.out.println("In position " + itemsFound[i][1]);
                                        i++;
                                    }
                                }else{
                                    System.out.println("Item not found");
                                }
                                break;
                        }
                    } while (option2 !=5);
                    break;
                case 2:// Change username name
                    System.out.println("Enter user userName");
                    userName=s.nextLine();
                    if(listNotes.searchUsers(userName)!=null){
                        System.out.println("Enter new username");
                        newUserName=s.nextLine();
                        user=listNotes.changeUserName(userName, newUserName);
                    }else{
                        System.out.println("Username not found");
                    }
                    break;
            }
        } while (option1 != 3);
    }
    private static void showMainMenu() {
        System.out.println("1 - Log in or create new user");
        System.out.println("2 - Change username");
        System.out.println("3 - Quit");
    }

    private static void showListMenu() {
        System.out.println("1 - New list");
        System.out.println("2 - Select list by name");
        System.out.println("3 - Select list by number");
        System.out.println("4 - Search item");
        System.out.println("5 - Log out");
    }

    private static void showItemMenu() {
        System.out.println("1 - Add item");
        System.out.println("2 - Modify item");
        System.out.println("3 - Remove item");
        System.out.println("4 - Sort by name increasingly");
        System.out.println("5 - Sort by name decreasingly");
        System.out.println("6 - Go back to List Menu");
    }

}
