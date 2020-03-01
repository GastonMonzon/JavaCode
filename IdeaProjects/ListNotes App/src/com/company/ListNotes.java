package com.company;

import java.util.ArrayList;

public class ListNotes {
    private ArrayList<UserName> users;

    public ListNotes() {
        this.users = new ArrayList<>();
    }

    public UserName singIn(String name) {
            this.users.add(new UserName(name));
            return searchUsers(name);
    }

    public UserName searchUsers(String name) {
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getName().equals(name)) {
//                return this.users.get(i);
//            }
        for (UserName user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public UserName changeUserName(String name, String newName){
        UserName user = searchUsers(name);
        user.setName(newName);
        return user;
    }

}
