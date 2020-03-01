package com.company;

import java.util.LinkedList;
import java.util.*;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);

    private static void showMainMenu(){
        System.out.println("0 - Show menu");
        System.out.println("1 - Add Album");
        System.out.println("2 - Add song to album");
        System.out.println("3 - Show album songs");
        System.out.println("4 - Add songs to playlist");
        System.out.println("5 - Add songs after last song played on playlist");
        System.out.println("6 - Show playlist");
        System.out.println("7 - Go to playlist");
        System.out.println("8 - Quit");
    }

    private static void showPlaylistMenu(){
        System.out.println("0 - Show playlist menu");
        System.out.println("1 - Show playlist");
        System.out.println("2 - Play playlist from the beginning");
        System.out.println("3 - Play/Skip next song in playlist");
        System.out.println("4 - Play/Skip previous song in playlist");
        System.out.println("5 - Stop playing playlist");
        System.out.println("6 - Remove current song in playlist");
        System.out.println("7 - Remove songs from playlist");
        System.out.println("8 - Go back to Main menu");
    }

    private static void showPlaylist(LinkedList<Songs> playlist){
        if(playlist.size()==0){
            System.out.println("Playlist is empty");
        }else{
            ListIterator<Songs> it= playlist.listIterator();
            int i=0;
            while (it.hasNext()){
                System.out.println(i+1 + " " + it.next().getTitle());
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Music myMusic = new Music("Gatuno");
        LinkedList<Songs> playlist = new LinkedList<>();
        int option, option2, trackNumber, playlistNumber=0;
        String albumName, artistName, songName;
        double songDuration;
        boolean forward=true, quit=false, quit2=false;

        myMusic.addAlbum("Jamaica" , "Althor");
        myMusic.searchAlbum("Jamaica").addSongs("Ahoy", 5.3);
        myMusic.searchAlbum("Jamaica").addSongs("There", 6.2);
        myMusic.searchAlbum("Jamaica").addSongs("Mike", 3.3);
        myMusic.searchAlbum("Jamaica").addSongs("More", 8.2);
        myMusic.searchAlbum("Jamaica").addSongs("Where", 4.5);
        myMusic.searchAlbum("Jamaica").addSongs("A lot", 5.1);
        myMusic.searchAlbum("Jamaica").addSongs("Mikasa", 2.8);
        myMusic.searchAlbum("Jamaica").addSongs("Although", 5.0);
        myMusic.searchAlbum("Jamaica").addSongs("Geronimo", 4.2);
        myMusic.searchAlbum("Jamaica").addSongs("Here", 4.8);
        myMusic.searchAlbum("Jamaica").addSongs("There again", 3.1);
        myMusic.searchAlbum("Jamaica").addSongs("Why", 6.0);
        myMusic.addAlbum("Alabama" , "Kino");
        myMusic.searchAlbum("Alabama").addSongs("Mackintosh", 2.3);
        myMusic.searchAlbum("Alabama").addSongs("Altokara", 4.5);
        myMusic.searchAlbum("Alabama").addSongs("Silver", 3.6);
        myMusic.searchAlbum("Alabama").addSongs("Online", 8.9);
        myMusic.searchAlbum("Alabama").addSongs("Silhouette", 5.1);
        myMusic.searchAlbum("Alabama").addSongs("Whereabouts", 4.3);
        myMusic.searchAlbum("Alabama").addSongs("Offline", 6.4);
        myMusic.searchAlbum("Alabama").addSongs("Come", 3.7);

        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(1));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(2));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(3));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(4));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(5));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(6));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(7));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(8));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(9));
        playlist.add(myMusic.searchAlbum("Jamaica").getSongs().songs.get(10));

        showMainMenu();

        do {
            option = s.nextInt();
            s.nextLine();

            switch (option) {
                case 0:
                    showMainMenu();
                    break;
                case 1:
                    System.out.println("Enter album name");
                    albumName = s.nextLine();
                    System.out.println("Enter artist name");
                    artistName = s.nextLine();
                    myMusic.addAlbum(albumName, artistName);
                    System.out.println("Album " + myMusic.searchAlbum(albumName).getName() + " added");
                    break;
                case 2:
                    System.out.println("Enter album name to add song");
                    albumName = s.nextLine();
                    if (myMusic.searchAlbum(albumName) == null) {
                        System.out.println("Album not found");
                    } else {
                        System.out.println("Enter song name");
                        songName = s.nextLine();
                        System.out.println("Enter song duration");
                        songDuration = s.nextDouble();
                        myMusic.searchAlbum(albumName).addSongs(songName, songDuration);
                        System.out.println("Song " + songName + " added");
                    }
                    break;
                case 3:
                    System.out.println("Enter album to show");
                    albumName = s.nextLine();
                    if (myMusic.searchAlbum(albumName) == null) {
                        System.out.println("Album not found");
                    } else {
                        Album myAlbum = (myMusic.searchAlbum(albumName));
                        System.out.println(myAlbum.getName() + " by " + myAlbum.getArtist());
                        myAlbum.showSongs(myAlbum);
                    }
                    break;
                case 4:
                    System.out.println("Enter album name to add songs from");
                    albumName = s.nextLine();
                    if (myMusic.searchAlbum(albumName) == null) {
                        System.out.println("Album not found");
                    } else {
                        Album myAlbum = (myMusic.searchAlbum(albumName));
                        System.out.println(myAlbum.getName() + " by " + myAlbum.getArtist());
                        myAlbum.showSongs(myAlbum);
                        do {
                            System.out.println("Enter track number to add or 0 to exit");
                            trackNumber = s.nextInt();
                            if (trackNumber != 0) {
                                if (myAlbum.getSongs().songs.size() <= trackNumber - 1) {
                                    System.out.println("Song track number not found");
                                } else {
                                    playlist.add(myAlbum.getSongs().songs.get(trackNumber - 1));
                                    System.out.println("Song: " + myAlbum.getSongs().songs.get(trackNumber - 1).getTitle() + " added to playlist");
                                }
                            }
                        } while (trackNumber != 0);
                        showMainMenu();
                    }
                    break;
                case 5:
                    System.out.println("Enter album name to add songs from");
                    albumName=s.nextLine();
                    if(myMusic.searchAlbum(albumName)==null){
                        System.out.println("Album not found");
                    }else{
                        Album myAlbum=(myMusic.searchAlbum(albumName));
                        System.out.println(myAlbum.getName() + " by " + myAlbum.getArtist());
                        myAlbum.showSongs(myAlbum);
                        do{
                            System.out.println("Enter track number to add or 0 to exit");
                            trackNumber=s.nextInt();
                            if(trackNumber!=0) {
                                if (myAlbum.getSongs().songs.size() <= trackNumber - 1) {
                                    System.out.println("Song track number not found");
                                } else {
                                    playlist.add(playlistNumber, myAlbum.getSongs().songs.get(trackNumber - 1));
                                    System.out.println("Song: " + myAlbum.getSongs().songs.get(trackNumber - 1).getTitle() + " added to playlist");
                                }
                            }
                        }while(trackNumber!=0);
                        showMainMenu();
                    }
                    break;
                case 6:
                    showPlaylist(playlist);
                    break;
                case 7:
                    ListIterator<Songs> it = playlist.listIterator();
                    for(int i=0; i<playlistNumber; i++){
                        it.next();
                    }
                    showPlaylistMenu();
                    do {
                        option2=s.nextInt();
                        s.nextLine();
                        switch (option2) {
                            case 0:
                                showPlaylistMenu();
                                break;
                            case 1:
                                showPlaylist(playlist);
                                break;
                            case 2:
                                if (playlist.size() == 0) {
                                    System.out.println("Playlist is empty");
                                } else {
                                    while (it.hasPrevious()) {
                                        it.previous();
                                    }
                                    System.out.println("Now playing " + it.next().getTitle());
                                    forward = true;
                                    playlistNumber = 1;
                                }
                                break;
                            case 3:
                                if (playlist.size() == 0) {
                                    System.out.println("Playlist is empty");
                                } else {
                                    if(!forward){
                                        if(it.hasNext()){
                                            it.next();
                                        }
                                        forward=true;
                                    }
                                    if (it.hasNext()) {
                                        System.out.println("Now playing " + it.next().getTitle());
                                        playlistNumber++;
                                    } else {
                                        System.out.println("Reached end of playlist");
                                        forward=true;
                                    }
                                }
                                break;
                            case 4:
                                if (playlist.size() == 0) {
                                    System.out.println("Playlist is empty");
                                } else {
                                    if (forward) {
                                        if (it.hasPrevious()) {
                                            it.previous();
                                        }
                                        forward = false;
                                    }
                                    if (it.hasPrevious()) {
                                        System.out.println("Now playing " + it.previous().getTitle());
                                        playlistNumber--;
                                    } else {
                                        System.out.println("Reached beginning of playlist\nNow playing " + it.next().getTitle());
                                        forward = true;
                                    }
                                }
                                break;
                            case 5:
                                if (playlist.size() == 0) {
                                    System.out.println("Playlist is empty");
                                } else {
                                    if(forward) {
                                        if (it.hasPrevious()) {
                                            it.previous();
                                        }
                                    }
                                    System.out.println("Stopped playing in " + it.next().getTitle());
                                    forward = true;
                                }
                                break;
                            case 6:
                                if(playlist.size()==0){
                                    System.out.println("Playlist is empty");
                                }else {
                                    if (!forward) {
                                        if (it.hasNext()) {
                                            it.next();
                                        }
                                        forward = true;
                                    }
                                        if(it.hasPrevious()){
                                            it.previous();
                                        System.out.println("Removing " + it.next().getTitle() + " from playlist");
                                        it.remove();
                                        if(it.hasNext()){
                                            System.out.println("Now playing " + it.next().getTitle());
                                        }else if(it.hasPrevious()){
                                            System.out.println("Now playing " + it.previous().getTitle());
                                            playlistNumber--;
                                            forward=false;
                                        }else{
                                            System.out.println("Playlist is empty");
                                            playlistNumber=0;
                                        }
                                    }
                                }
                                break;
                            case 7:
                                if(playlist.size()==0){
                                    System.out.println("Playlist is empty");
                                }else {
                                    do {
                                        showPlaylist(playlist);
                                        System.out.println("Enter track number to remove or 0 to exit");
                                        trackNumber = s.nextInt();
                                        if (trackNumber != 0) {
                                            if (trackNumber > playlist.size()) {
                                                System.out.println("Song track number not found");
                                            } else {
                                                while (it.hasPrevious()) {
                                                    it.previous();
                                                }
                                                playlistNumber=0;
                                                for (int k = 0; k < trackNumber; k++) {
                                                    it.next();
                                                    playlistNumber++;
                                                }
                                                if(it.hasPrevious()){
                                                    it.previous();
                                                }
                                                System.out.println("Removing " + it.next().getTitle() + " from playlist");
                                                it.remove();
                                                if (it.hasNext()) {
                                                    System.out.println("Now playing " + it.next().getTitle());
                                                    forward = true;
                                                } else if (it.hasPrevious()) {
                                                    System.out.println("Now playing " + it.previous().getTitle());
                                                    forward = false;
                                                }
                                                if (playlist.size() == 0) {
                                                    System.out.println("Playlist is empty");
                                                }
                                            }
                                        }
                                    } while (trackNumber != 0 && playlist.size() != 0);
                                    showPlaylistMenu();
                                }
                                break;
                            case 8:
                                quit2=true;
                                showMainMenu();
                                break;
                        }
                    }while(!quit2);
                    quit2=false;
                    break;
                case 8:
                    quit=true;
                    break;
            }
        }while(!quit);
    }
}
