package es.socialfilms.social_films.repository;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Director;

public interface DirectorRepository extends CrudRepository<Director, Long>{
    // ...
}
