package com.company;

import java.util.ArrayList;

public class UserName {
    private String name;
    private ArrayList<List> listOfLists;

    public UserName(String name) {
        this.name = name;
        this.listOfLists = new ArrayList<>();
    }

    public void addList(String name){
        this.listOfLists.add(new List(name));
    }

    public void showListOfNotes(){
        if(listOfLists.isEmpty()){
            System.out.println("There are no lists created");
        }else {
            for (int i = 0; i < listOfLists.size(); i++) {
                System.out.println(i + 1 + " " + listOfLists.get(i).getName());
            }
            System.out.println();
        }
    }

    public List searchLists(String name) {
        for (List listOfList : listOfLists) {
            if (listOfList.getName().equals(name)) {
                return listOfList;
            }
        }
        return null;
    }

    public String[][] searchItem(String item) {
        String[][] itemsFound= new String[100][2];
        int k=0;
        for (List list : listOfLists) {
            for (int j = 0; j < list.getList().size(); j++) {
                if (list.getList().get(j).equals(item)) {
                    itemsFound[k][0]=list.getName();
                    itemsFound[k][1]= String.valueOf(list.getList().indexOf(item));
                    k++;
                }
            }
        }
        return itemsFound;
    }

    public String getName() {
        return name;
    }

    public ArrayList<List> getListOfLists() {
        return listOfLists;
    }

    public void setName(String name) {
        this.name = name;
    }
}
