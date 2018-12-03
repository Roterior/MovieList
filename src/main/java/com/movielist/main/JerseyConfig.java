package com.movielist.main;

import com.movielist.servlets.MovieController;
import com.movielist.servlets.ReviewController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(MovieController.class);
        register(ReviewController.class);
    }
}
