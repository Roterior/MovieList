package com.movielist.impls;

import com.movielist.interfaces.MovieAccessService;
import com.movielist.interfaces.MovieService;
import com.movielist.main.entity.Genre;
import com.movielist.main.entity.Movie;
import com.movielist.main.entity.TitleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieServiceImpl(MovieAccessService movieAccessService) {
        this.movieAccessService = movieAccessService;
    }

    private final MovieAccessService movieAccessService;

    @Override
    public List<Movie> get(double toRating, double fromRating, int toYear, int fromYear, String title, int year, double rating, String genre, String mType) {
        return movieAccessService.get(toRating, fromRating, toYear, fromYear, title, year, rating, genre, mType);
    }

    @Override
    public Movie getByImdbId(String imdbId) {
        return movieAccessService.getByImdbId(imdbId);
    }

    @Override
    public List<Genre> getGenre() {
        return movieAccessService.getGenre();
    }

    @Override
    public List<TitleType> getTitleType() {
        return movieAccessService.getTitleType();
    }
}
