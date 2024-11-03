package es.socialfilms.social_films.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.socialfilms.social_films.dto.FilmData;
import es.socialfilms.social_films.repository.FilmRepository;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public List<FilmData> getAllFilms(){
        
        List<FilmData> films = filmRepository.findAllByOrderById().stream()
            .map(film -> modelMapper.map(film, FilmData.class))
            .collect(Collectors.toList());

        return films;
    }

    @Transactional(readOnly = true)
    public FilmData findById(Long id){
        return modelMapper.map(filmRepository.findFilmById(id), FilmData.class);
    }
}
