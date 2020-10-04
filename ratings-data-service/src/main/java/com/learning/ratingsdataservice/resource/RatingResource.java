package com.learning.ratingsdataservice.resource;


import com.learning.ratingsdataservice.models.Rating;
import com.learning.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        List<Rating> ratings =  Arrays.asList(
                new Rating("100",5),
                new Rating("200",4)
        );
        userRating.setRatingList(ratings);
        return userRating;
    }
}