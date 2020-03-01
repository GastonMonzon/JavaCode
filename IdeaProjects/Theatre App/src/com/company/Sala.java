package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Sala {
    private String nameNumber;
    private int numRows;
    private int seatsPerRow;
    private int inequalRows;
    private List<Seat> seats = new ArrayList<>();


    public Sala(String nameNumber, int numRows, int seatsPerRow) {
        this.nameNumber = nameNumber;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getNameNumber() {
        return nameNumber;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setNameNumber(String nameNumber) {
        this.nameNumber = nameNumber;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Collection<Seat> getSeats() {
        int j=0;
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seats.get(i);
            if(j!=this.seatsPerRow-1) {
                System.out.print(seat.getSeatNumber() + " ");
                j++;
            }else{
                System.out.print(seat.getSeatNumber() + "\n");
                j=0;
            }
        }
        return seats;
    }

    public class Seat implements Comparable<Theatre.Seat>{
        private final String seatNumber;
        //        private double price;
        private boolean reserved=false;

        public Seat(String seatNumber/*, double price*/) {
            this.seatNumber = seatNumber;
//            this.price = price;
        }

        @Override
        public int compareTo(Theatre.Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved=true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            }
            return false;
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved=false;
                System.out.println("Reservation of seat " + seatNumber + " canceled");
                return true;
            }
            return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

//        public double getPrice() {
//            return price;
//        }
    }
}
