package com.example.project4.Controller;

import com.example.project4.Model.Director;
import com.example.project4.Service.DirectorService;
import com.example.project4.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {
    private final DirectorService directorService;
    private final MovieService movieService;


    @GetMapping("/get")
    public ResponseEntity getDirectors(){
        return ResponseEntity.status(200).body(directorService.getDirectors());
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("director added");
    }

    @PutMapping("/update")
    public  ResponseEntity updateDirector(@Valid @RequestBody Director director,@PathVariable Integer id){
        directorService.updateDirector(id,director);
        return ResponseEntity.status(200).body("director deleted");
    }
}
