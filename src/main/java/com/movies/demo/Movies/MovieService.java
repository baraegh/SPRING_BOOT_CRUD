package com.movies.demo.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieService {

	@Autowired
	private MovieRepository repository;
    
  public Flux<Movie> getMovies() { 
    System.out.println("service: getMovies method called ...");
		return repository.findAll();
	}

  public Mono<Movie> getMovies(String id) { 
    System.out.println("service: getMovies by id method called ...");
		return repository.findById(id);
	}

	public Mono<Movie> saveMovie(Movie movie){
    System.out.println("service: saveMovie method called ...");
    return repository.save(movie);
  }

  public Mono<Movie> updateMovie(Movie movie, String id)
  {
    return repository.findById(id)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")))
                    .flatMap(existingMovie -> {
                        existingMovie.setName(movie.getName());
                        existingMovie.setDescription(movie.getDescription());
                        existingMovie.setYear(movie.getYear());

                        return repository.save(existingMovie);
                    });
  }

  public Mono<Void> deleteMovie(String id)
  {
    return repository.deleteById(id);
  }
}
