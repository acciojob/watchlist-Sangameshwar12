package com.driver;

public class Movie {
    public String movie;
    public int durationMinutes;
    public double imbdRating;

    public Movie(String name, int durationMinutes, double imbdRating) {
        this.movie = name;
        this.durationMinutes = durationMinutes;
        this.imbdRating = imbdRating;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }
}
