package com.movielist.impls;

import com.movielist.interfaces.ReviewAccessService;
import com.movielist.main.entity.Review;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Component
@Repository
@Service
@Transactional
public class ReviewAccessServiceImpl implements ReviewAccessService {

    public ReviewAccessServiceImpl() {}

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void delete(int rId, String login) {
        TypedQuery<Review> q = em.createQuery("SELECT r FROM Review r WHERE r.rId = :rId AND r.login = :login", Review.class);
        q.setParameter("rId", rId);
        q.setParameter("login", login);
        Review review = q.getSingleResult();
        em.remove(review);
    }

    @Override
    @Transactional
    public void editReview(int rId, String login, String description, double rating) {
        TypedQuery<Review> q = em.createQuery("SELECT r FROM Review r WHERE r.rId = :rId AND r.login = :login", Review.class);
        q.setParameter("rId", rId);
        q.setParameter("login", login);
        Review review = q.getSingleResult();
        review.setrDescription(description);
        review.setRating(rating);
        em.persist(review);
    }

    @Override
    public List<Review> getByLogin(String login) {
        TypedQuery<Review> q = em.createQuery("SELECT r FROM Review r WHERE r.login = :login", Review.class);
        q.setParameter("login", login);
        return q.getResultList();
    }

    @Override
    public Review addNew(String imdbId, String login, String rDescription, double rating) {
        Date dateCreate = new Date(System.currentTimeMillis());
        Review review = new Review(imdbId, login, dateCreate, rating, rDescription);
        em.persist(review);
        return review;
    }
}
