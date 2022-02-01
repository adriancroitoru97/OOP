package lab5.task4;

public class DangerousAlbum extends Album {
    boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addSong(Song song) {
        if (isPrime(song.getId())) {
            getSongs().add(song);
        }
    }
}
