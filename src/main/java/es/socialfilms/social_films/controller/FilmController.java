package es.socialfilms.social_films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import es.socialfilms.social_films.dto.ActorData;
import es.socialfilms.social_films.dto.DirectorData;
import es.socialfilms.social_films.dto.FilmData;
import es.socialfilms.social_films.dto.GenreData;
import es.socialfilms.social_films.dto.ReviewData;
import es.socialfilms.social_films.service.FilmService;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/film/all")
    @ResponseBody
    public List<FilmData> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("/film/{id}")
    public String getFilmById(@PathVariable Long id, Model model) {
        
        FilmData film = filmService.findById(id);
        model.addAttribute("filmData", film);

        DirectorData directorData = filmService.getDirector(id);
        model.addAttribute("directorData", directorData);

        List<GenreData> genres = filmService.getGenre(id);
        model.addAttribute("genreList", genres);

        List<ActorData> cast = filmService.getCast(id);
        model.addAttribute("cast", cast);

        List<ReviewData> reviews = filmService.getReviews(id);
        model.addAttribute("reviews", reviews);

        return "filmInfo"; 
    }
}
