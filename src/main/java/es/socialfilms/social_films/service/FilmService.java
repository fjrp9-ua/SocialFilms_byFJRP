package es.socialfilms.social_films.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.socialfilms.social_films.dto.ActorData;
import es.socialfilms.social_films.dto.DirectorData;
import es.socialfilms.social_films.dto.FilmData;
import es.socialfilms.social_films.dto.GenreData;
import es.socialfilms.social_films.dto.ReviewData;
import es.socialfilms.social_films.model.Film;
import es.socialfilms.social_films.model.Review;
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
        return modelMapper.map(filmRepository.findById(id).orElse(null), FilmData.class);
    }

    @Transactional(readOnly = true)
    public DirectorData getDirector(Long filmId){
        Film film = filmRepository.findById(filmId).orElse(null);
        if (film == null) return null;
        return modelMapper.map(film.getDirector(), DirectorData.class);
    }

    @Transactional(readOnly = true)
    public List<GenreData> getGenre(Long filmId){
        Film film = filmRepository.findById(filmId).orElse(null);
        if (film == null) return null;

        List<GenreData> genres = film.getGenres().stream()
                                    .map(genre -> modelMapper.map(genre, GenreData.class))
                                    .collect(Collectors.toList());
        
        return genres;
    }

    @Transactional(readOnly = true)
    public List<ActorData> getCast(Long filmId){
        Film film = filmRepository.findById(filmId).orElse(null);
        if (film == null) return null;

        List<ActorData> cast = film.getActors().stream()
                                    .map(actor -> modelMapper.map(actor, ActorData.class))
                                    .collect(Collectors.toList());
        
        return cast;
    }

    @Transactional(readOnly = true)
    public List<ReviewData> getReviews(Long filmId){
        Film film = filmRepository.findById(filmId).orElse(null);
        if (film == null) return null;

        Set<Review> reviews = film.getReviews();
        List<ReviewData> reviewDataList = new ArrayList<>();
        for (Review review : reviews){
            reviewDataList.add(modelMapper.map(review, ReviewData.class));
            reviewDataList.get(reviewDataList.size()-1).setUserName(review.getUser().getUserName());
        }
        
        return reviewDataList;
    }
}
