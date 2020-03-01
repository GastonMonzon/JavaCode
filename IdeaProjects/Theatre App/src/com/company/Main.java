package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner s = new Scanner(System.in);

    public static void showMainMenu(){
        System.out.println("1 - Enter Theatre name");
        System.out.println("2 - Change Theatre name");
        System.out.println("");
        System.out.println(" - Quit");

    }
    public static void main(String[] args) {

        int option1, option2, option3;
        String seatNumber;

        Theatre theatre = new Theatre("Imax", 4, 5);
        Sala sala = new Sala("Imax", 9, 16);
        sala.getSeats();

        do{
            showMainMenu();
            option1=s.nextInt();
            s.nextLine();
            switch(option1){
                case 1:
                    System.out.println("Enter Theatre name");
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }

        }while(option1!=10);
    }
}
