package com.movielist.impls;

import com.movielist.interfaces.ReviewAccessService;
import com.movielist.interfaces.ReviewService;
import com.movielist.main.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    public ReviewServiceImpl(ReviewAccessService reviewAccessService) {
        this.reviewAccessService = reviewAccessService;
    }

    private final ReviewAccessService reviewAccessService;

    @Override
    public Review addNew(String imdbId, String login, String description, double rating) {
        return reviewAccessService.addNew(imdbId, login, description, rating);
    }
    @Override
    public List<Review> getByLogin(String login) {
        return reviewAccessService.getByLogin(login);
    }

    @Override
    public void editReview(int rId, String login, String description, double rating) {
        reviewAccessService.editReview(rId, login, description, rating);
    }

    @Override
    public void delete(int rId, String login) {
        reviewAccessService.delete(rId, login);
    }
}
