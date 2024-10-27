package es.socialfilms.social_films.repository;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
