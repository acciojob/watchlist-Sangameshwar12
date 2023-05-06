package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieDb = new HashMap<>();

    private HashMap<String, Director> dirctorDb = new HashMap<>();

    private HashMap<String, List<String>> directorMoviedb = new HashMap<>();

    public void addMovie(Movie movie){

        String name = movie.getMovie();
        movieDb.put(name, movie);

    }

    public void addDirector(Director director){

        dirctorDb.put(director.getDirector(), director);
    }

    public void directorMoviePair(String movie, String director){

        if(movieDb.containsKey(movie) && dirctorDb.containsKey(director)){

            List<String> currentMoviesByDirector = new ArrayList<>();
            if(directorMoviedb.containsKey(director)){

                currentMoviesByDirector = directorMoviedb.get(director);
                currentMoviesByDirector.add(movie);

                directorMoviedb.put(director, currentMoviesByDirector);

            }
        }
    }

    public Movie getMovieByName(String move){

        Movie movie = movieDb.get(move);
        return movie;
    }

    public Director getDirectorByName(String director){

        return dirctorDb.get(director);
    }

    public List<String> getMoviesByDirectorName(String direcotr){

        List<String> nameOfMovies = directorMoviedb.get(direcotr);
        return nameOfMovies;
    }

    public List<String> getAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteDirectorByName(String name){

        List<String> movies = new ArrayList<>();

        // 1. finding all the movies from directorMoviePair

        if(directorMoviedb.containsKey(name)){

            movies = directorMoviedb.get(name);

            // 2. deleting all the movies from director movies pair

            for(String movie : movies){
                if(directorMoviedb.containsKey(movie)){
                    directorMoviedb.remove(movie);
                }
            }
            // 3. deleting the pair

            directorMoviedb.remove(name);
        }
        // 4. deleting director from the directorDb
        if(dirctorDb.containsKey(name)){
            dirctorDb.remove(name);
        }
    }

    public void deleteAllMovies(){
        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        dirctorDb = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: directorMoviedb.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: directorMoviedb.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        //clearing the pair.
        directorMoviedb = new HashMap<>();
    }
}
