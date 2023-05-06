package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    MovieRepository movieRepository = new MovieRepository();

    public void addMovie(Movie movie){

        movieRepository.addMovie(movie);

    }
    public void addDirector(Director director){

        movieRepository.addDirector(director);
    }

    public void directorMoviePair(String movie, String direcotr){

        movieRepository.directorMoviePair(movie, direcotr);
    }

    public Movie getMovieByName(String movie){

        return movieRepository.getMovieByName(movie);
    }

    public Director getDirectorByName(String director){
        return movieRepository.getDirectorByName(director);
    }

    public List<String> getAllMoviesByDirectorName(String direcotr){
        return movieRepository.getMoviesByDirectorName(direcotr);
    }

    public List<String> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    public void deleteDirectorByName(String director){

        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllMovies(){
        movieRepository.deleteAllMovies();
    }
}
