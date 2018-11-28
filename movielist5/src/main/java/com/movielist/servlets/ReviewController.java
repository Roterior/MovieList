package com.movielist.servlets;

import com.movielist.interfaces.ReviewService;
import com.movielist.main.dto.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.util.List;

@Component
@Path("/review")
@Consumes("application/json")
@Produces("application/json")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @DELETE
    @Path("/delete") // Example: http://localhost:8081/review/delete?rId=100
    public void delete(@QueryParam("rId") int rId, @Context HttpServletRequest req) {
        HttpSession session = req.getSession();
        String login = session.getAttribute("login").toString();
        reviewService.delete(rId, login);
    }

    @PUT
    @Path("/view/edit") // Example: http://localhost:8081/review/view/edit?rId=100&description=textTest&rating=4.9
    public void edit(@QueryParam("rId") int rId, @QueryParam("description") String description,
                     @QueryParam("rating") double rating, @Context HttpServletRequest req) {
        HttpSession session = req.getSession();
        String login = session.getAttribute("login").toString();
        reviewService.editReview(rId,login,description,rating);
    }

    @GET
    @Path("/view") // Example: http://localhost:8081/review/view
    public List<Review> getByLogin(@Context HttpServletRequest req) {
        HttpSession session = req.getSession();
        String login = session.getAttribute("login").toString();
        return reviewService.getByLogin(login);
    }

    @POST
    @Path("/{imdbId}/add") // Example: http://localhost:8081/review/tt1270797/add?description=text&rating=6.5
    public Review add(@PathParam("imdbId") String imdbId, @QueryParam("description") String description,
                      @QueryParam("rating") double rating, @Context HttpServletRequest req) {
        HttpSession session = req.getSession();
        String login = session.getAttribute("login").toString();
        return reviewService.addNew(imdbId, login, description, rating);
    }
}
