package es.socialfilms.social_films.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String review;

    private float rating;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors ...

    public Review(){}

    public Review(String review, float rating){
        this.review = review;
        this.rating = rating;
    }

    // Getters and Setters ...

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getReview(){
        return review;
    }

    public void setReview(String review){
        this.review = review;
    }

    public float getRating(){
        return rating;
    }

    public void setRating(float rating){
        this.rating = rating;
    }

    // Relationship: Review *-1 Film

    public Film getFilm(){
        return film;
    }

    public void setFilm(Film film){
        if (this.film != film){
            this.film = film;
            film.addReview(this);
        }
    }

    // Relationship: Review *-1 User

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        if(this.user != user ){
            this.user = user;
            //user.addReview(this);
        }
    }

    // Overrides ...

    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;
        if (this.id != null && review.id != null) return Objects.equals(this.getId(), review.getId());
        return getReview().equals(review.getReview()) && getRating() == review.getRating();
    }

    public int hashCode(){
        return Objects.hash(review, rating);
    }
}
