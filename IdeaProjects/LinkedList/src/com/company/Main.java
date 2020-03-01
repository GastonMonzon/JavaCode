package com.company;

import java.util.*;

public class Main {

    private static Scanner s= new Scanner(System.in);

    private static void showMenu(){
        System.out.println("1 - Go to beginning");
        System.out.println("2 - Next city");
        System.out.println("3 - Previous city");
        System.out.println("4 - Go to end");
        System.out.println("5 - Show list");
        System.out.println("6 - Show Menu");
        System.out.println("7 - Quit");
    }
    public static void main(String[] args) {
        LinkedList<String> places = new LinkedList<>();

        addInOrder(places, "Camberra");
        addInOrder(places, "Serranto");
        addInOrder(places, "Maquialo");
        addInOrder(places, "Libmialo");
        addInOrder(places, "Solate");
        addInOrder(places, "Crema");
        addInOrder(places, "Empieza");
        addInOrder(places, "Salute");
        addInOrder(places, "Tremitak");
        ListIterator<String> it= places.listIterator();
        showMenu();
        int option;
        boolean forward=true;
        do {
            option=s.nextInt();
            switch (option){
                case 1:
                    if(places.getFirst().isEmpty()){
                        System.out.println("List empty");
                    }else{
                        while(it.hasPrevious()){
                            it.previous();
                        }
                        System.out.println("Starting with " + it.next());
                        forward=true;
                    }
                    break;
                case 2:
                    if(!forward){
                        if(it.hasNext()){
                            it.next();
                        }
                        forward=true;
                    }
                    if(it.hasNext()) {
                        System.out.println("Now visiting " + it.next());
                    } else {
                        System.out.println("Reached end of the list");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(it.hasPrevious()){
                            it.previous();
                        }
                        forward=false;
                    }
                    if(it.hasPrevious()){
                        System.out.println("Now visiting " + it.previous());
                    }else {
                        System.out.println("Reached start of the list");
                        forward = true;
                    }
                    break;
                case 4:
                    if(places.getLast().isEmpty())
                        System.out.println("List empty");
                    else {
                        while (it.hasNext()) {
                            it.next();
                        }
                        System.out.println("Last visiting " + it.previous());
                        forward = false;
                    }
                    break;
                case 5:
                    showList(places);
                    break;
                case 6:
                    showMenu();
            }

        }while(option!=7);
    }

    private static void showList(LinkedList<String> list){
        Iterator<String> i=list.iterator();
        int j=0;
        while (i.hasNext()){
            System.out.println(j+1 + " " + i.next());
            j++;
        }
        System.out.println("*********************");
    }
    private static boolean addInOrder(LinkedList<String> list, String data){
        ListIterator<String> i = list.listIterator();
        while (i.hasNext()) {
            int compare = i.next().compareTo(data);
            if (compare == 0) {
                System.out.println(data + " already on list");
                return false;
            } else if (compare > 0) {
                i.previous();
                i.add(data);
                return true;
            }
        }
        i.add(data);
        return true;
    }
}
