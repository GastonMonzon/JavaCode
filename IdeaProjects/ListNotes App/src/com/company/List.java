package com.company;

import java.util.LinkedList;

public class List {
    private String name;
    private LinkedList<String> list = new LinkedList<>();

    public List(String name) {
        this.name = name;
    }

    public void showList(){
        for(int i = 0; i< this.list.size(); i++){
            System.out.println(i+1 + " " + this.list.get(i));
        }
        System.out.println();
    }

    public void addItem(String item){
        this.list.add(item);
    }

    public void modifyItem(int position, String newItem){
        if(this.list.get(position)!=null){
            System.out.println("Item " + this.list.get(position) + " replaced with " + newItem);
            this.list.set(position, newItem);
        }else
            System.out.println("Item not found");
        System.out.println();
    }

    public void removeItem(int position){
        if(this.list.get(position)!=null){
            System.out.println("Item " + this.list.get(position) + " removed");
            this.list.remove(position);
        }else
            System.out.println("Item not found");
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public LinkedList<String> getList() {
        return list;
    }
}
