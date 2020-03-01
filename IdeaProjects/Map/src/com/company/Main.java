package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner s = new Scanner(System.in);
    private static void showMap(Map<String, String> map){
        for(String i: map.keySet()){
            System.out.println(i + ": " + map.get(i));
        }
        System.out.println();
    }
    private static void putInMap(Map<String, String> map, String name, String details){
        if(map.containsKey(name)){
            System.out.println(name + " already exists.");
        }else{
            map.put(name, details);
        }
    }
    private static void modifyMapDetails(Map<String, String> map, String name, String details){
        if(map.containsKey(name)){
            map.replace(name, details);
            System.out.println(name + " replaced");
        }else{
            System.out.println(name  + " not found");
        }
    }
    private static void modifyMapDetails(Map<String, String> map, String name, String details, String newDetails){
        if(map.replace(name, details, newDetails)){
            System.out.println(name + " replaced");
        }else{
            System.out.println(name + " or " + details + " not found");
        }
    }
    private static void modifyMapNames(Map<String, String> map, String name, String newName){
        if(map.containsKey(name)){
            String details = map.remove(name);
            System.out.println(name + " changed to " + newName);
            map.put(newName, details);
        }else{
            System.out.println(name + " not found");
        }
    }
    private static void removeFromMap(Map<String, String> map, String name){
        if(map.containsKey(name)){
            System.out.println(name + ": " + map.get(name) + "\nRemoved");
            map.remove(name);
        }else{
            System.out.println(name + " not found");
        }
    }

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        String key;

        System.out.println(languages.put("C", "Don't know it"));// This shows null
        System.out.println(languages.get("C"));//Now it doesn't as it's after it's declared
        System.out.println();

        putInMap(languages, "Java", "Difficult to learn");
        putInMap(languages,"Python", "Maybe what i should be learning");
        putInMap(languages,"Algol", "I don't know what it is");
        putInMap(languages, "BASIC", "Cool to learn");
        putInMap(languages, "C++", "I liked it");

        showMap(languages);

        modifyMapDetails(languages, "C", "I know a little");
        System.out.println();
        removeFromMap(languages, "Algol");
        System.out.println();
        modifyMapNames(languages, "BASIC", "Basic");
        System.out.println();
        modifyMapDetails(languages, "Java", "Difficult to learn", "Maybe they are all difficult");
        System.out.println();

        showMap(languages);
    }
}
