package com.movielist.interfaces;

import com.movielist.main.dto.Genre;
import com.movielist.main.dto.Movie;
import com.movielist.main.dto.TitleType;

import java.util.List;

public interface MovieService {

    Movie getByImdbId(String imdbId);

    List<Genre> getGenre();

    List<TitleType> getTitleType();

    List<Movie> get(double toRating, double fromRating, int toYear, int fromYear, String title);
}
