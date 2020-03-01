package com.company;

import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public void addSongs(String songTitle, double songDuration){
        this.songs.addSong(new Songs(songTitle, songDuration));
    }

    public void showSongs(Album album){
            for(int i=0; i<album.getSongs().songs.size(); i++){
                System.out.println(i+1 + " " + album.getSongs().songs.get(i).getTitle() + " " + album.getSongs().songs.get(i).getDuration());
            }
    }

    public String getName() {
        return name;
    }
    public String getArtist() {
        return artist;
    }
    public SongList getSongs() {
        return songs;
    }

    public static class SongList{
        public ArrayList<Songs> songs;

        private SongList(){
            this.songs = new ArrayList<>();
        }

        private void addSong(Songs song){
            this.songs.add(song);
        }
    }
}
