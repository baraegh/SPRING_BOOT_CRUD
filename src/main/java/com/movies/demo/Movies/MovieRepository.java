package com.movies.demo.Movies;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository 
    extends ReactiveMongoRepository<Movie, String> {
    
}
