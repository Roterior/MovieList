package com.movielist.impls;

import com.movielist.interfaces.MovieAccessService;
import com.movielist.main.dto.Genre;
import com.movielist.main.dto.Movie;
import com.movielist.main.dto.TitleType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Service
@Repository
@Transactional(readOnly = true)
public class MovieAccessServiceImpl implements MovieAccessService {

    public MovieAccessServiceImpl() {}

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Movie> get(double toRating, double fromRating, int toYear, int fromYear, String title) {
        String query = "";
        boolean isFirst = true;
        if (toRating != 0) {
            if (isFirst) {
                query += " SELECT m FROM Movie m WHERE m.rating <= :toRating ";
                isFirst = false;
            }
        }
        if (fromRating != 0) {
            if (isFirst) {
                query += " SELECT m FROM Movie m WHERE m.rating >= :fromRating ";
                isFirst = false;
            }
            else { query += " AND m.rating >= :fromRating "; }
        }
        if (toYear != 0) {
            if (isFirst) {
                query += " SELECT m FROM Movie m WHERE m.releaseYear <= :toYear ";
                isFirst = false;
            }
            else { query += " AND m.releaseYear <= :toYear "; }
        }
        if (fromYear != 0) {
            if (isFirst) {
                query += " SELECT m FROM Movie m WHERE m.releaseYear >= :fromYear ";
                isFirst = false;
            }
            else { query += " AND m.releaseYear >= :fromYear "; }
        }
        if (title != null) {
            if (isFirst) {
                query += " SELECT m FROM Movie m WHERE m.title LIKE :title ";
                isFirst = false;
            }
            else { query += " AND m.title LIKE :title "; }
        }
        TypedQuery<Movie> q = em.createQuery(query, Movie.class);
        if (toRating != 0) q.setParameter("toRating", toRating);
        if (fromRating != 0) q.setParameter("fromRating", fromRating);
        if (toYear != 0) q.setParameter("toYear", toYear);
        if (fromYear != 0) q.setParameter("fromYear", fromYear);
        if (title != null) q.setParameter("title", "%" + title + "%");
        return q.getResultList();
    }

    @Override
    public Movie getByImdbId(String imdbId) {
        TypedQuery<Movie> q = em.createQuery("SELECT m FROM Movie m WHERE m.imdbId = :imdbId", Movie.class);
        q.setParameter("imdbId", imdbId);
        return q.getSingleResult();
    }

    @Override
    public List<Genre> getGenre() {
        TypedQuery<Genre> q = em.createQuery("SELECT g FROM Genre g", Genre.class);
        return q.getResultList();
    }

    @Override
    public List<TitleType> getTitleType() {
        TypedQuery<TitleType> q = em.createQuery("SELECT t FROM TitleType t", TitleType.class);
        return q.getResultList();
    }
}
