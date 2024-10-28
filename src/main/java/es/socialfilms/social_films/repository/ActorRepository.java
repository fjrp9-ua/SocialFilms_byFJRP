package es.socialfilms.social_films.repository;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long>{
    // ...
}
