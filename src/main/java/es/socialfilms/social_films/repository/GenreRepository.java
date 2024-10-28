package es.socialfilms.social_films.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long>  {
    Optional<Genre> findByName(String name);
}
