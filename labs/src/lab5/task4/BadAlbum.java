package lab5.task4;

public class BadAlbum extends Album {

    boolean isPalindrome(int number) {
        int number_reversed = 0;
        int number_cpy = number;
        while (number_cpy != 0) {
            number_reversed = number_reversed * 10 + number_cpy % 10;
            number_cpy /= 10;
        }

        return number == number_reversed;
    }

    @Override
    public void addSong(Song song) {
        if (song.getName().length() == 3 &&
            isPalindrome(song.getId())) {
            getSongs().add(song);
        }
    }
}
