package com.example.project4.Repository;

import com.example.project4.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieById(Integer id);

    Movie findMovieByName(String name);
    List<Movie> findMovieByRating(Integer rate);

    @Query("select s from Movie s where s.directorId =?1")
    List<Movie> getMovieByDirectorId(Integer id);

    @Query("select s from Movie s where s.rating > ?1")
    List<Movie> getMovieByRating(Integer rating);

    List<Movie> findMovieByGenre(String genre);


}
