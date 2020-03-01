package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void printList(List<Theatre.Seat> list){
        for(Theatre.Seat seat : list){
            System.out.print(" " + seat.getSeatNumber() + " $" + seat.getPrice());
        }
        System.out.println();
    }

    public static void sortList(List<? extends Theatre.Seat> list){
        for(int i=0; i<list.size(); i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i).compareTo(list.get(j))>0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
    public static void main(String[] args) {

        Theatre theatre = new Theatre("Imax", 13, 32);

        theatre.getSeats();

        if(theatre.reserveSeat("J02")){
            System.out.println("Pay J02");
        }else{
            System.out.println("Seat already reserved");
        }
        if(theatre.reserveSeat("D12")){
            System.out.println("Pay D12");
        }else{
            System.out.println("Seat already reserved");
        }
        if(theatre.reserveSeat("A02")){
            System.out.println("Pay A02");
        }else{
            System.out.println("Seat already reserved");
        }
        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);


//        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
//        printList(seatCopy);
//        seatCopy.get(1).reserve();
//
//        Collections.shuffle(seatCopy);
//        System.out.println();
//        printList(seatCopy);
//        System.out.println();
//        printList(theatre.seats);
//
//        Theatre.Seat minSeat = Collections.min(seatCopy);
//        Theatre.Seat maxSeat = Collections.max(seatCopy);
//        System.out.println(minSeat.getSeatNumber());
//        System.out.println(maxSeat.getSeatNumber());
//
//        sortList(seatCopy);
//        System.out.println();
//        printList(seatCopy);
//        theatre.getSeats();
//        if(theatre.reserveSeat("H11")){
//            System.out.println("Pay");
//        }else{
//            System.out.println("Seat not available");
//        }
//        if(theatre.reserveSeat("H11")){
//            System.out.println("Pay");
//        }else {
//            System.out.println("Seat not available");
//        }
    }
}
