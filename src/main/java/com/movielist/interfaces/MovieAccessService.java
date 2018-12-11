package com.movielist.interfaces;

import com.movielist.main.entity.Genre;
import com.movielist.main.entity.Movie;
import com.movielist.main.entity.TitleType;

import java.util.List;

public interface MovieAccessService {

    Movie getByImdbId(String imdbId);

    List<Genre> getGenre();

    List<TitleType> getTitleType();

    List<Movie> get(double toRating, double fromRating, int toYear, int fromYear, String title, int year, double rating, String genre, String mType);
}
