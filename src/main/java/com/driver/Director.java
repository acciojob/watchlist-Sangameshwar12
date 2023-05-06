package com.driver;

public class Director {
    public String director;

    public int muberOfMovies;

    public double imdbRating;

    public Director(String name, int muberOfMovies, double imdbRating) {
        this.director = name;
        this.muberOfMovies = muberOfMovies;
        this.imdbRating = imdbRating;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getMuberOfMovies() {
        return muberOfMovies;
    }

    public void setMuberOfMovies(int muberOfMovies) {
        this.muberOfMovies = muberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
