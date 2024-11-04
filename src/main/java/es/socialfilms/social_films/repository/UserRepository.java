package es.socialfilms.social_films.repository;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByUserName(String userName);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
