package com.softconassig.moviecatalogservice.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.softconassig.moviecatalogservice.models.CatalogItem;
import com.softconassig.moviecatalogservice.models.Movie;
import com.softconassig.moviecatalogservice.models.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResourse {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId")  String userId){ 
        UserRating ratings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);


        return ratings.getRatings().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getMovieName(), "desc", rating.getRating());
    }).collect(Collectors.toList());
    
       
    }

    
}