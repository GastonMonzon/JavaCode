package com.company;

import java.util.ArrayList;

public class Music {
    private String userName;
    private ArrayList<Album> album;

    public Music(String userName) {
        this.userName = userName;
        this.album = new ArrayList<Album>();
    }

    public void addAlbum(String name, String artist){
        this.album.add(new Album(name, artist));
    }

    public Album searchAlbum(String name){
        for(int i=0; i<album.size(); i++){
            if(album.get(i).getName().equals(name)){
                return this.album.get(i);
            }
        }
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public ArrayList<Album> getAlbum() {
        return album;
    }
}
