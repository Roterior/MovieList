package com.movielist.main.dto;

import com.movielist.main.entity.Movie;

public class MovieView {

    private String imdbId;
    private String mType;
    private String title;
    private String genre;
    private char isAdult;
    private int releaseYear;
    private double rating;
    private String mDescription;

    public MovieView() {}

    public static MovieView fromMovie(Movie movie) {
        MovieView dto = new MovieView();
        dto.setImdbId(movie.getImdbId());
        dto.setmType(movie.getType());
        dto.setTitle(movie.getTitle());
        dto.setGenre(movie.getGenre());
        dto.setIsAdult(movie.getIsAdult());
        dto.setReleaseYear(movie.getYear());
        dto.setRating(movie.getRating());
        dto.setmDescription(movie.getDescription());
        return dto;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public char getIsAdult() {
        return isAdult;
    }

    public void setIsAdult(char isAdult) {
        this.isAdult = isAdult;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
