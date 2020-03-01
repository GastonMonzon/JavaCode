package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int option=1;

//        locations.put(0, new Location(0,"You are at Starbucks"));
//        locations.put(1, new Location(1,"You are at The Office"));
//        locations.put(2, new Location(2,"You are at The Factory"));
//        locations.put(3, new Location(3,"You are Here"));
//        locations.put(4, new Location(4,"You are There"));
//        locations.put(5, new Location(5,"You are Everywere"));

//        locations.get(1).addExit("W", 2);
//        locations.get(1).addExit("E", 3);
//        locations.get(1).addExit("S", 4);
//        locations.get(1).addExit("N", 5);
////        locations.get(1).addExit("Q", 0);
//        locations.get(2).addExit("N", 5);
////        locations.get(2).addExit("Q", 0);
//        locations.get(3).addExit("W", 1);
////        locations.get(3).addExit("Q", 0);
//        locations.get(4).addExit("N", 1);
//        locations.get(4).addExit("W", 2);
////        locations.get(4).addExit("Q", 0);
//        locations.get(5).addExit("S", 1);
//        locations.get(5).addExit("W", 2);
////        locations.get(5).addExit("Q", 0);
        Map<String, Integer> tempExit= new HashMap<>();
        locations.put(0, new Location(0,"You are at Starbucks", null));

        tempExit= new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1,"You are at The Office", tempExit));

        tempExit= new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("N", 5);
        locations.put(2, new Location(2,"You are at The Factory", tempExit));
        tempExit= new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3,"You are Here", tempExit));

        tempExit= new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4,"You are There", tempExit));

        tempExit= new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5,"You are Everywhere", tempExit));//        locations.get(1).addExit("W", 2);

        Map<String, String> vocabulary= new HashMap<>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");


        do {
            System.out.println(locations.get(option).getDescription());


            Map<String, Integer> exits = locations.get(option).getExits();
            System.out.print("Available exits are: ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            String direction= s.nextLine().toUpperCase();
            if (direction.length() > 1){
                String[] words= direction.split(" ");
                for(String word: words){
                    if(vocabulary.containsKey(word)){
                        direction=vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction)){
                option=exits.get(direction);
            }else{
                System.out.println("Cannot go in that direction");
            }
        }while(option!=0);

        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
        for(String i: road){
            System.out.println(i);
        }
        String[] building= "You are inside a building, a well house for a small spring".split(", ");
        for(String i: building){
            System.out.println(i);
        }
    }
}