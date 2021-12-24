package lab8.MP3Player;

public class Song {
    private final String title;
    private final String artist;

    public Song(String title, String author) {
        this.title = title;
        this.artist = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Song{");
        sb.append("title=").append(title);
        sb.append(", artist=").append(artist);
        sb.append('}');
        return sb.toString();
    }
}