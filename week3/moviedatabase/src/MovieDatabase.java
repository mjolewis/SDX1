import java.io.*;
import java.util.*;

/**
 * A database of movies and the actors and actresses in the movies.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList; // An ArrayList of movies
    private ArrayList<Actor> actorList; // An ArrayList of actors

    /**
     * A constructor that creates a new movieList and a new actorList that are initially empty.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    /**
     * This method takes in the name of a movie along with a list of actors for that movie.
     * If the movie is already in the database, ignore this request.
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name
     * @param actors
     */
    public void addMovie(String name, String[] actors) {
        Movie newMovie = new Movie(name);
        if (!movieList.contains(newMovie)) {
            movieList.add(newMovie);
        }
        for (String actorName : actors) {
            Actor actor = new Actor(actorName);
            if (!actorList.contains(actor)) {
                actorList.add(actor);
            } else {
                actor = actorList.get(actorList.indexOf(actor));
            }
            /*
             * The code above only adds new actors to the list. However, we still need to know all of the movies
             * each actor was in so we can properly calculate the actor with the highest rated movies. For example
             * if Actor "John Doe" was in a movie rated 0 and a movie rated 100, his rating should be 50, not 0 or
             * 100 (whichever movie was in the list first).
             */
            newMovie.getActors().add(actor);
            actor.getMovies().add(newMovie);
        }
    }

    /**
     * Add a rating for this movie.
     * Assume that the name argument will definitely be a name that is currently in the database.
     * @param name
     * @param rating
     */
    public void addRating(String name, double rating) {
        if (movieList.indexOf(new Movie(name)) != -1) {
            movieList.get(movieList.indexOf(new Movie(name))).setRating(rating);
        }
    }

    /**
     * Overwrite the current rating of a movie with this new rating.
     * Assume that the name argument will definitely be a name that is currently in the database.
     * @param name
     * @param newRating
     */
    public void updateRating(String name, double newRating) {
        if (movieList.indexOf(new Movie(name)) != -1) {
            movieList.get(movieList.indexOf(new Movie(name))).setRating(newRating);
        }
    }

    /**
     * Returns the name of the actor that has the best average rating for their movies.
     * In the case of a tie, return any one of the best actors
     * @return
     */
    public String getBestActor() {
        Collections.sort(actorList);
        return actorList.get(actorList.size() - 1).getName();
    }

    /**
     * Returns the name of the movie with the highest rating.
     * In the case of a tie, return any one of the best actors.
     */
    public String getBestMovie() {
        Collections.sort(movieList);
        return movieList.get(movieList.size() - 1).getName();
    }

    public static void main(String[] args) {
        MovieDatabase movieDatabase = new MovieDatabase();

        /*
         * Read the movies
         */

        // The HashMap will contain the movies as keys and the values as an ArrayList of the movies actors
        Map<String, List<String>> movies = new HashMap<>();

        try (Scanner scanner = new Scanner(new File("movies.txt"))) {
            // scanner.NextLine returns the current line and moves the scanner to the next line
            while (scanner.hasNextLine()) {
                String[] movieInfo = scanner.nextLine().split(", ");
                for (int i = 1; i < movieInfo.length; i++) { // Index 0 is the actors name.
                    if (!movies.containsKey(movieInfo[i])) { // Add the movie as a key if it doesn't already exist
                        movies.put(movieInfo[i], new ArrayList<String>());
                    }
                    movies.get(movieInfo[i]).add(movieInfo[0]); // For each key, add the actor as the value
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * Add the movies to the movie database
         */
        for (String movie : movies.keySet()) {
            List<String> actors = movies.get(movie);
            movieDatabase.addMovie(movie, actors.toArray(new String[actors.size()]));
        }

        /*
         * Read the ratings
         */
        try (Scanner scanner = new Scanner(new File("ratings.txt"))) {
            scanner.nextLine(); // This lets us skip the headers in the file.
            while (scanner.hasNextLine()) {
                String[] ratings = scanner.nextLine().split("\t");
                movieDatabase.addRating(ratings[0], Double.parseDouble(ratings[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * Find the best actor and the best movie
         */
        System.out.println(movieDatabase.getBestActor());
        System.out.println(movieDatabase.getBestMovie());
    }
}
