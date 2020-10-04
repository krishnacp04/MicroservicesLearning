package com.learning.moviecatalogservice.models;

import com.learning.ratingsdataservice.models.Rating;

import java.util.List;

public class UserRating{
    List<com.learning.ratingsdataservice.models.Rating> ratingList;

    public UserRating() {
    }

    public List<com.learning.ratingsdataservice.models.Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
