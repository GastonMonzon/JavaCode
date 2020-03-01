package com.company;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addItem(String item){
        groceryList.add(item);
    }

    public void showList(){
        for(int i=0; i<groceryList.size();i++){
            System.out.println(i+1 + " " + groceryList.get(i));
        }
    }

    public void searchItem(String item){
        if(groceryList.indexOf(item)<0){
            System.out.println("Item not found");
        }else{
            System.out.println("Item " + item + " found on position " + groceryList.indexOf(item));
        }
    }

    public void modifyItem(int position, String item){
        System.out.println("Modifying item " + position + " " + groceryList.get(position) + " with " + item);
        groceryList.set(position, item);
    }

    public void modifyItem(String item){
        searchItem(item);
    }

    public void removeItem(int position){
        groceryList.remove(position);
    }
}
