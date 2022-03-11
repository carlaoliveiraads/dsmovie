package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional
    public Page<MovieDTO> findAll(Pageable pageable){
      Page<Movie> result =  repository.findAll(pageable);
        return result.map(x -> new MovieDTO(x));


    }


    @Transactional
    public MovieDTO findByid(Long id){
        Movie result =  repository.findById(id).get();
        return new MovieDTO(result);

    }

}
