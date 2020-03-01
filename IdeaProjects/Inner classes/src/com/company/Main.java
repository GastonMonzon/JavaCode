package com.company;

public class Main {

    public static void main(String[] args) {
        Gearbox mclaren = new Gearbox(6);
        mclaren.addGear(1, 5.3);
        mclaren.addGear(2, 10.6);
        mclaren.addGear(3, 15.9);
        mclaren.operateClutch(true);
        mclaren.chacgeGear(1);
        mclaren.operateClutch(false);
        mclaren.chacgeGear(2);
        mclaren.operateClutch(true);
        mclaren.chacgeGear(3);
        System.out.println(mclaren.wheelspeed(6500));
        
    }
}
