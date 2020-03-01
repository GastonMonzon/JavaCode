package com.company;

public class ClassCounter {
    private static int classCounter = 0;// As this is static it will change every time the class is instanced
    private final int instaceCounter;// If this is public it won't compile and allow you to change it
    private final String name;

    public ClassCounter(String name) {
        this.name = name;
        classCounter++;
        this.instaceCounter = classCounter;
        System.out.println(name + " created, instance is " + instaceCounter);
    }

    public static int getClassCounter() {
        return classCounter;
    }

    public int getInstaceCounter() {
        return instaceCounter;
    }

    public String getName() {
        return name;
    }
}
