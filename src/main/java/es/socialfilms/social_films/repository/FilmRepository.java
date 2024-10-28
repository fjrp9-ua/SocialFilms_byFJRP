package es.socialfilms.social_films.repository;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {
//...
}
