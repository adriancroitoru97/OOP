package lab5.task4;

public class Song {
    private final String name;
    private final int id;
    private final String composer;

    public Song(String name, int id, String composer) {
        this.name = name;
        this.id = id;
        this.composer = composer;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", composer='" + composer + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getComposer() {
        return composer;
    }
}
