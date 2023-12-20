package be.shwan.clonenetflix.graphql.dto;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public record Movie(String title, String cover, String year, Float cost, List<Star> starring) {

    private static final List<Movie> MOVIES = new ArrayList<>();

    static {
        try {
            getDefault();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getDefault() throws FileNotFoundException {
        FileReader fileReader = new FileReader("src/main/resources/movies.json");
        Gson gson = new Gson();
        Movie[] movies = gson.fromJson(fileReader, Movie[].class);
        for (Movie movie : movies) {
            MOVIES.add(new Movie(movie.title(), movie.cover(), movie.year(), movie.cost(), movie.starring()));
        }
    }

    public static List<Movie> get() {
        return MOVIES;
    }

    public static Movie getById(int id) {
        return MOVIES.get(id);
    }
}
