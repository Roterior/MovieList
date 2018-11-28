package com.movielist.main.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TitleType {

    @Id
    private String titleType;

    public TitleType() {}

    public TitleType(String movieType) {
        this.titleType = movieType;
    }

    public String getTitleType() { return titleType; }
    public void setTitleType(String titleType) { this.titleType = titleType; }

    @Override
    public String toString() {
        return "TitleType{" +
                "titleType='" + titleType + '\'' +
                '}';
    }
}
