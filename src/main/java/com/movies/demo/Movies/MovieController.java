package com.movies.demo.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "api/v1/movies")
public class MovieController {

    @Autowired
    private final MovieService movieService;
    
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
	public Flux<Movie> getMovies() { 
		return movieService.getMovies();
	}

    @GetMapping("/{id}")
	public Mono<Movie> getMovies(@PathVariable String id) { 
		return movieService.getMovies(id);
	}

    @PostMapping
    public Mono<Movie> saveMovie(@RequestBody Movie movie) {
        return movieService.saveMovie(movie);
    }

    @PutMapping("/update/{id}")
    public Mono<Movie> updateMovie(@RequestBody Movie movie, @PathVariable String id) {
        return movieService.updateMovie(movie, id);
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteMovie(@PathVariable String id) {
        return movieService.deleteMovie(id);
    }
    
}
