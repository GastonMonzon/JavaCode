package com.company;

public class Main {

    public static void main(String[] args) {

        ClassCounter one = new ClassCounter("First");
        ClassCounter two = new ClassCounter("Second");
        ClassCounter three = new ClassCounter("Third");

        System.out.println(one.getInstaceCounter());
        System.out.println(two.getInstaceCounter());
        System.out.println(three.getInstaceCounter());

        Password password = new ExtendedPassword(52849173);
        password.storePassword();
        password.enter(128469);
        password.enter(52849173);
        System.out.println();

        System.out.println("Main method called");
        StaticInitializationBlockTest test = new StaticInitializationBlockTest();
		test.someMethod();
		System.out.println(StaticInitializationBlockTest.owner);

    }
}
