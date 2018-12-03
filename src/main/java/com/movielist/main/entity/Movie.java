package com.movielist.main.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Movie {

    @Id
    private String imdbId;
    private String mType;
    private String title;
    private String genre;
    private char isAdult;
    private int releaseYear;
    private double rating;
    private String mDescription;

    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER)
    private List<Review> review;

    public Movie() {}

    public Movie(String imdbId, String mType, String title, String genre, char isAdult, int releaseYear, double rating, String mDescription) {
        this.imdbId = imdbId;
        this.mType = mType;
        this.title = title;
        this.genre = genre;
        this.isAdult = isAdult;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.mDescription = mDescription;
    }

    public String getImdbId() { return imdbId; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }
    public String getType() { return mType; }
    public void setType(String mType) { this.mType = mType; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public char getIsAdult() { return isAdult; }
    public void setIsAdult(char isAdult) { this.isAdult = isAdult; }
    public int getYear() { return releaseYear; }
    public void setYear(int releaseYear) { this.releaseYear = releaseYear; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getDescription() { return mDescription; }
    public void setDescription(String mDescription) { this.mDescription = mDescription; }

    public List<Review> getReview() { return review; }
    public void setReview(List<Review> review) { this.review = review; }

    @Override
    public String toString() {
        return "\nMovie { " +
                "imdbId='" + imdbId + '\'' +
                ", type='" + mType + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", year=" + releaseYear +
                ", rating=" + rating +
                ", description='" + mDescription + '\'' +
                '}';
    }
}
