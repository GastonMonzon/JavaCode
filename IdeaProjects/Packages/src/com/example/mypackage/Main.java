package com.example.mypackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int index =0, option;
        boolean quit=false;
        do{
            System.out.println("0 - Exit");
            System.out.println("1 - Enter a string");

            option=s.nextInt();
            s.nextLine();
            switch (option){
                case 0:
                    quit=true;
                    break;
                case 1:
                    System.out.println("Enter a string");
                    String stringinput= s.nextLine();
                    values.add(index, stringinput);
                    index++;
            }
        }while(!quit);
        return values;
    }

    public static void saveObject(ISaveable objectToSave){
            for( int i=0; i<objectToSave.write().size(); i++){
                System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
            }
        }

        public static void loadObject(ISaveable objectToLoad){
            ArrayList<String> values = readValues();
            objectToLoad.read(values);
        }
        public static void main(String[] args) {

            Player tron = new Player("Tron", 100, 10);
            System.out.println(tron.toString());
            saveObject(tron);
            tron.setHitpoints(80);
            System.out.println(tron);
            tron.setWeapon("Bow");
            saveObject(tron);
            loadObject(tron);
        System.out.println(tron);

        ISaveable monster = new Monster("Kraken", 200, 50);
        System.out.println(monster);
        System.out.println("Strength " + ((Monster) monster).getStrength());

        ISaveable werewolf = new Monster("Werewolf", 30, 23);
        System.out.println("Hitpoints " + ((Monster) werewolf).getHitpoints());
    }
}
