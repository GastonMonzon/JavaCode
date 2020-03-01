package com.company;

public class Printer {
    private double toner=0;
    private int numberOfPages=0;
    private boolean isDuplex;

    public Printer(double toner, int numberOfPages, boolean isDuplex){
        if(toner>0 && toner <=100)
            this.toner = toner;
        if(numberOfPages>0 && numberOfPages<=100)
            this.numberOfPages = numberOfPages;
        this.isDuplex = isDuplex;
    }

    public void filltoner(int toner){
        if(toner<0){
            System.out.println("Can't add negative toner");
        } else if(this.toner==100){
            System.out.println("Printer full, can't add toner");
        } else if(this.toner+toner<=100){
            this.toner+=toner;
            System.out.println(toner + "% toner added, toner%: " + this.toner);
        }else{
            System.out.println("Can't fill toner more than 100%, fill with less than " + (100-this.toner) + "%");
        }
    }

    public void addPages(int pages){
        if(pages<0){
            System.out.println("Can't add negative pages");
        } else if(this.numberOfPages==100){
            System.out.println("Printer full, can't add pages");
        } else if(this.numberOfPages+pages<=100){
            this.numberOfPages+=pages;
            System.out.println(pages + " added, number of pages on printer: " + this.numberOfPages);
        }else{
            System.out.println(100-this.numberOfPages + " added, " + (pages-(100-this.numberOfPages)) + " left out");
            this.numberOfPages = 100;
        }
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public double getToner() {
        return toner;
    }
    public void printPages(int printedPages, boolean goodQuality, boolean graphic){
        int i=printedPages;
        boolean turnedPage=false;
        while(this.toner>0 && this.numberOfPages>0){
            if(goodQuality && graphic){
                this.toner--;
            }else if(!goodQuality && !graphic) {
                this.toner-=0.25;
            }else{
                this.toner-=0.75;
                }
            System.out.println("Printing");
            if(!this.isDuplex) {
                this.numberOfPages--;
                i--;
            }else{
                if(turnedPage){
                    turnedPage=false;
                }else{
                    this.numberOfPages--;
                    i--;
                    System.out.println("Turn page around");
                    turnedPage=true;
                }
        }
        }
        if(this.toner<1){
            System.out.println("Toner depleated");
        }
        if(this.numberOfPages<1){
            System.out.println("Page tray empty");
        }
    }
}
