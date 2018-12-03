package com.movielist.main.entity;

import com.movielist.main.entity.Movie;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rev")
    @SequenceGenerator(name = "rev", sequenceName = "REVIEW_RID_SEQ")
    private int rId;
    private String imdbId;
    private String login;
    private Date dateCreate;
    private double rating;
    private String rDescription;

    @ManyToOne
    @JoinColumn(name = "imdbId", insertable = false, updatable = false)
    private Movie movie;

    public Review() {}

    public Review(String imdbId, String login, Date dateCreate, double rating, String rDescription) {
        //this.rId = rId;
        this.imdbId = imdbId;
        this.login = login;
        this.dateCreate = dateCreate;
        this.rating = rating;
        this.rDescription = rDescription;
    }

    public int getrId() { return rId; }
    public void setrId(int rId) { this.rId = rId; }
    public String getImdbId() { return imdbId; }
    public void setImdbId(String imdbId) { this.imdbId = imdbId; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public Date getDateCreate() { return dateCreate; }
    public void setDateCreate(Date dateCreate) { this.dateCreate = dateCreate; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public String getrDescription() { return rDescription; }
    public void setrDescription(String rDescription) { this.rDescription = rDescription; }

    @Override
    public String toString() {
        return "\nReview { " +
                "imdbId='" + imdbId + '\'' +
                ", dateCreate='" + dateCreate + '\'' +
                ", login='" + login + '\'' +
                ", rDescription='" + rDescription + '\'' +
                ", rating=" + rating +
                '}';
    }
}
