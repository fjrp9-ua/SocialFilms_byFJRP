package es.socialfilms.social_films.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import es.socialfilms.social_films.model.Review;

public interface ReviewRepository extends CrudRepository<Review, Long>{

    Optional<Review> findReviewById(Long id);
}
