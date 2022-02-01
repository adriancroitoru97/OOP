package lab5.task4;

import java.util.Objects;

public class ThrillerAlbum extends Album {

    @Override
    public void addSong(Song song) {
        if (song.getId() % 2 == 0 &&
                Objects.equals(song.getComposer(), "Michael Jackson")) {
            getSongs().add(song);
        }
    }
}
