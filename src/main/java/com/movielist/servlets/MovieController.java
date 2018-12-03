package com.movielist.servlets;

import com.movielist.interfaces.MovieService;
import com.movielist.main.entity.Genre;
import com.movielist.main.entity.Movie;
import com.movielist.main.dto.MovieView;
import com.movielist.main.entity.TitleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Path("/movie")
@Consumes("application/json")
@Produces("application/json")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GET
    @Path("/{imdbId}") // Example: http://localhost:8081/movie/tt1270797
    public Movie getByImdbId(@PathParam("imdbId") String imdbId) {
        return movieService.getByImdbId(imdbId);
    }

    @GET
    @Path("/view") // Example: http://localhost:8081/movie/view?toRating=9&title=e
    public List<MovieView> get(@QueryParam("toRating") double toRating, @QueryParam("fromRating") double fromRating,
                               @QueryParam("toYear") int toYear, @QueryParam("fromYear") int fromYear,
                               @QueryParam("title") String title) {
        List<Movie> movie = movieService.get(toRating, fromRating, toYear, fromYear, title);
        List<MovieView> result = new ArrayList<>(movie.size());
        for (Movie m : movie) result.add(MovieView.fromMovie(m));
        return result;
    }

    @GET
    @Path("/genre") // Example: http://localhost:8081/movie/genre
    public List<Genre> getGenre() {
        return movieService.getGenre();
    }

    @GET
    @Path("/titleType") // Example: http://localhost:8081/movie/titleType
    public List<TitleType> getTitleType() {
        return movieService.getTitleType();
    }
}
