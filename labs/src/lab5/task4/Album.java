package lab5.task4;

import java.util.ArrayList;

public abstract class Album {
    private ArrayList<Song> songs = new ArrayList<>();

    public abstract void addSong(Song song);

    void removeSong(Song song) {
        songs.remove(song);
    }

    @Override
    public String toString() {
        return "Album{" +
                "songs=" + songs +
                '}';
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
