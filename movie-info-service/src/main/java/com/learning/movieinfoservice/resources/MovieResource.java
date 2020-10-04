package com.learning.movieinfoservice.resources;

import com.learning.movieinfoservice.models.Movie;
import com.learning.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Value("${moviedb.url}")
    private String movieDBUrl;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        MovieSummary movieSummary = restTemplate.getForObject(movieDBUrl+movieId+"?api_key="+apiKey, MovieSummary.class);
        return new Movie(movieId, movieSummary.getOriginal_title(), movieSummary.getOverview());
    }
}
