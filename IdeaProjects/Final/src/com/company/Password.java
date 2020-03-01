package com.company;

public class Password {
    private static final int key=16461654;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password){
        return password ^ key;
    }

    public /*final*/ void storePassword(){// So it can't be overwritten
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean enter(int password){
        if(encryptDecrypt(password)==this.encryptedPassword){
            System.out.println("Welcome");
            return true;
        }
        System.out.println("Invalid password");
        return false;
    }
}
