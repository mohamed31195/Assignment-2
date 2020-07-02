package com.softconassig.movieinfoservice.models;

public class Movie {
    private String movieId;
    private String movieName;

    public Movie(String movieId, String movieName){
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public String getMovieId() {
        return this.movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}