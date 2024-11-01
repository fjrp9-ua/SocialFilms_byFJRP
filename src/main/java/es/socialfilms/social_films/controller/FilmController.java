package es.socialfilms.social_films.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.socialfilms.social_films.dto.FilmData;
import es.socialfilms.social_films.service.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/films/all")
    @ResponseBody
    public List<FilmData> getAllFilms() {
        return filmService.getAllFilms();
    }
    
}
