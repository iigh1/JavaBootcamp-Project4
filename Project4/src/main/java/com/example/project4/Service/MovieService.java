package com.example.project4.Service;

import com.example.project4.ApiException.ApiException;
import com.example.project4.Model.Movie;
import com.example.project4.Repository.DirectorRepository;
import com.example.project4.Repository.MovieRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;


    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void  updateMovie(Integer id, Movie movie){
       Movie movie1= movieRepository.findMovieById(id);
       if (movie1==null){
           throw new ApiException("movie not found");
       }

       movie1.setName(movie.getName());
       movie1.setDuration(movie.getDuration());
       movie1.setGenre(movie.getGenre());
       movie1.setRating(movie.getRating());

       movieRepository.save(movie1);
    }

    public void deleteMovie(Integer id){
        Movie movie1 =movieRepository.findMovieById(id);
        if (movie1==null){
            throw new ApiException("movie not found");
        }
        movieRepository.delete(movie1);
    }

    public Movie searchMovie(String name){
        Movie movie1= movieRepository.findMovieByName(name);
        if (movie1==null){
            throw new ApiException("movie not found");
        }
        return movie1;
    }
    public Integer getDuration(String name){
        Movie movie1= movieRepository.findMovieByName(name);
        if (movie1==null){
            throw new ApiException("movie not found");
        }
        return movie1.getDuration();
    }

    public String getDirector(String name){
        Movie movie1= movieRepository.findMovieByName(name);
        if (movie1==null){
            throw new ApiException("movie not found");
        }
        return getDirector(name);
    }

    public List<Movie> getListMovies(String name){
        if (directorRepository.findDirectorByName(name)==null){
            throw  new ApiException("not found");
        }
        return movieRepository.getMovieByDirectorId(directorRepository.findDirectorByName(name).getId());
    }

    public Integer getMovieByRate(String name){
        Movie movie1= movieRepository.findMovieByName(name);
        if (movie1==null){
            throw new ApiException("movie not found");
        }
        return movieRepository.findMovieByName(name).getRating();
    }

    public List<Movie> getMovieHighRate(Integer rating){
        List<Movie>movies= movieRepository.getMovieByRating(rating);
        if (movies==null){
            throw new ApiException("movie not found");
        }
        return movies;
    }

    public List<Movie> getMoviesByGenre(String genre){
        List<Movie> movies = movieRepository.findMovieByGenre(genre);
        if (movies==null){
            throw new ApiException("movie not found");
        }
        return movies;
    }
}
