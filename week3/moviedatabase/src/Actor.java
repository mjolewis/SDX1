import java.util.*;

/**
 * An arrayList of movie actors.
 */
public class Actor implements Comparable<Actor> {
    private String name; // The full name of the actor or actress.
    private ArrayList<Movie> movies; // An ArrayList of movies the current actor or actress has acted in.

    public Actor(String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    public Actor() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public ArrayList<Movie> getMovie() {
        return movies;
    }

    public void setMovie(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public boolean equals(Object object) {
        return ((Actor) object).getName().equals(name);
    }

    public String toString() {
        return name + " average rating: " + getActorRating();
    }

    public double getActorRating() {
        double ratingSum = 0;
        for (Movie movie : movies) {
            ratingSum += movie.getRating();
        }
        return ratingSum / movies.size();
    }

    public int compareTo(Actor o) {
        Double rating = getActorRating();
        if (rating > o.getActorRating()) {
            return 1;
        } else if (rating < o.getActorRating()) {
            return -1;
        } else {
            return 0;
        }
    }
}
