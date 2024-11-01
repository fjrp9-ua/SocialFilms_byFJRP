package es.socialfilms.social_films.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

    public List<Film> findAll();

    public List<Film> findAllByOrderById();
}
