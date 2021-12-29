package k2.najdobriFilmovi;

import java.util.*;
import java.util.stream.Collectors;

public class Movie {
    private final String title;
    private final List<Integer> ratings;

    public Movie(String title, int[] ratings) {
        this.title = title;
        this.ratings = Arrays.stream(ratings).boxed().collect(Collectors.toList());
    }

    public double averageRating() {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String getTitle() {
        return title;
    }

    public int getRatingsAmount() {
        return ratings.size();
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f) of %d ratings", title, averageRating(), getRatingsAmount());
    }
}