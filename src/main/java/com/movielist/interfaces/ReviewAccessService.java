package com.movielist.interfaces;

import com.movielist.main.entity.Review;
import java.util.List;

public interface ReviewAccessService {

    Review addNew(String imdbId, String login, String description, double rating);

    List<Review> getByLogin(String login);

    void editReview(int rId, String login, String description, double rating);

    void delete(int rId, String login);
}
