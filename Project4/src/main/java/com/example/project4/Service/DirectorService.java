package com.example.project4.Service;

import com.example.project4.ApiException.ApiException;
import com.example.project4.Model.Director;
import com.example.project4.Repository.DirectorRepository;
import com.example.project4.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;


    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }

    public void addDirector(Director director){
        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director){
        Director director1 = directorRepository.findDirectorById(id);

        if (director1==null){
            throw new ApiException("director not found");
        }

        director1.setName(director.getName());
        director1.setId(director.getId());
        directorRepository.save(director1);
    }

    public void deleteDirector(Integer id){
        Director director1= directorRepository.findDirectorById(id);
        if (director1==null){
            throw new ApiException("director not found");
        }
        directorRepository.delete(director1);


    }
}
