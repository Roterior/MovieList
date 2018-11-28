package com.movielist.main.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genre {

    @Id
    private String genre;

    public Genre() {}

    public Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Genre{" +
                "genre='" + genre + '\'' +
                '}';
    }
}
