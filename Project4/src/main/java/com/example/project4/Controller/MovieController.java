package com.example.project4.Controller;

import com.example.project4.Model.Movie;
import com.example.project4.Service.DirectorService;
import com.example.project4.Service.MovieService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;


    @GetMapping("/get")
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("movie added");
    }

    @PutMapping("/update")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie, @PathVariable Integer id){
        movieService.updateMovie(id,movie);
        return ResponseEntity.status(200).body("movie updated");
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("movie deleted");
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity search(@PathVariable String title){
        Movie movie = movieService.searchMovie(title);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/get-duration/{name}")
    public ResponseEntity getDuration(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getDuration(name));
    }

    @GetMapping("/get-director/{name}")

    public ResponseEntity getDirector(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getDirector(name));
    }

    @GetMapping("/get-list/{name}")
    public ResponseEntity getListMovies(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getListMovies(name));
    }

    @GetMapping("/get-rate{name}")
    public ResponseEntity getRating(@PathVariable String name){
        return ResponseEntity.status(200).body(movieService.getMovieByRate(name));
    }

    @GetMapping("/get-rating/{rating}")
    public ResponseEntity getHighRating(@PathVariable Integer rating){
        return ResponseEntity.status(200).body(movieService.getMovieHighRate(rating));
    }

    @GetMapping("/get-genre/{genre}")
    public ResponseEntity getGenre(@PathVariable String genre){
        return ResponseEntity.status(200).body(movieService.getMoviesByGenre(genre));
    }
}
