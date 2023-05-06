package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService = new MovieService();

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){

        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);

    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    // Pair an existing movie and direcotr
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> directorMoviePair(@RequestParam("movie")String movie, @RequestParam("director")String director){
        return new ResponseEntity<>("New director movie pair added Successfully", HttpStatus.CREATED);
    }

    // Get Movie by movie name
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByname(@PathVariable String name){

        Movie movie = movieService.getMovieByName(name);

        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    // 6. Get Director by director name
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){

        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    // 7. Get List of all movies added
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getAllMoviesByNameOfDirector(@PathVariable String name){

        List<String> moviesNameByDirector = movieService.getAllMoviesByDirectorName(name);

        return new ResponseEntity<>(moviesNameByDirector, HttpStatus.CREATED);
    }

    // 8. Delete a director and its movies from the records
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies(){

        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.CREATED);
    }


    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String director){

        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(director + "removed successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){

        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }

}
