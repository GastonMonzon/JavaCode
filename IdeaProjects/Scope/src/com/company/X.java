package com.company;

import java.util.Scanner;

public class X {
    private int x;

    public X(int x){
        this.x=x;
    }

    public int getX() {
        return x;
    }

    public void x(){
        for(int x=1; x<13; x++){
            System.out.println(this.x + " * " + x + " = " + x*this.x);
        }
    }

    public void x(Scanner X){
        System.out.println("Enter number to see its times table up to 12");
        this.x=X.nextInt();
        for(x=0; x<13; x++){
            System.out.println(this.x + " * " + x + " = " + x*this.x);
        }
    }
}
