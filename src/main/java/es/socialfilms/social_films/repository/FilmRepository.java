package es.socialfilms.social_films.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

    List<Film> findAll();

    List<Film> findAllByOrderById();

    Optional<Film> findById(Long id);
}
