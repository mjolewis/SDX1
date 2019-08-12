import java.util.*;

/**
 * A list of movies and an ArrayList of the actors that were in the movie
 */
public class Movie implements Comparable<Movie> {
    private String name; // The name of the movie
    private ArrayList<Actor> actors; // An ArrayList of the actors in the movie
    private double rating; // A freshness rating from rotten tomatoes

    public Movie(String name) {
        this.name = name;
        rating = 0.0;
        actors = new ArrayList<>();
    }

    public Movie() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean equals(Object object) {
        return ((Movie) object).getName().equals(name);
    }

    public int compareTo(Movie o) {
        if (rating > o.getRating()) {
            return 1;
        } else if (rating < o.getRating()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Actor name is: " + name;
    }
}
