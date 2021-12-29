package k2.najdobriFilmovi;

import java.util.*;
import java.util.stream.Collectors;

public class MoviesList {
    private final List<Movie> movies;

    public MoviesList() {
        this.movies = new ArrayList<>();
    }

    public void addMovie(String title, int[] ratings) {
        movies.add(new Movie(title, ratings));
    }

    public List<Movie> top10ByAvgRating() {
        return movies.stream().sorted(Comparator.comparing(Movie::averageRating).reversed().thenComparing(Movie::getTitle)).limit(10).collect(Collectors.toList());
    }

    public List<Movie> top10ByRatingCoef() {
        return movies.stream().sorted(Comparator.comparing(this::rating).reversed().thenComparing(Movie::getTitle)).limit(10).collect(Collectors.toList());
    }

    private double rating(Movie movie) {
        double averageRating = movie.averageRating();
        int ratingsAmount = movie.getRatingsAmount();
        int maxRatingsAmount = movies.stream().mapToInt(Movie::getRatingsAmount).max().orElse(0);

        return averageRating * ratingsAmount / maxRatingsAmount;
    }
}