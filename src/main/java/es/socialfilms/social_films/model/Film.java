package es.socialfilms.social_films.model;

import java.io.Serializable;
import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "films")
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "release_year")
    private int releaseYear;

    @Column(name = "running_time")
    private int runningTime;

    private String country;
    
    private String synopsis;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director; 
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_actor",
        joinColumns = {@JoinColumn(name = "fk_film")},
        inverseJoinColumns = {@JoinColumn(name = "fk_actor")})
    private Set<Actor> actors = new HashSet<>(); 

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_genre",
        joinColumns = {@JoinColumn(name = "fk_film")},
        inverseJoinColumns = {@JoinColumn(name = "fk_genre")})
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(mappedBy = "film")
    private Set<Review> reviews = new HashSet<>();

    // Constructors...

    public Film(){}
    
    public Film(String title){
        this.title = title;
    }

    // Getters and Setters...

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }

    public int getReleaseYear(){
        return releaseYear;
    }
    
    public void setReleaseYear(int releaseYear){
        this.releaseYear = releaseYear;
    }

    public int getRunningTime(){
        return runningTime;
    }
    
    public void setRunningTime(int runningTime){
        this.runningTime = runningTime;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    // Relationship: Film *-* Genre

    public Set<Genre> getGenres(){
        return genres;
    }

    public void addGenre(Genre genre){
        if(this.getGenres().contains(genre)) return;
        this.getGenres().add(genre);
        if(!genre.getFilms().contains(this)) {
            genre.getFilms().add(this);
        } 
    }

    // Relationship: Film *-1 Director

    public Director getDirector(){
        return director;
    }

    public void setDirector(Director director){
        if (this.director != director){
            this.director = director;
            director.addFilm(this);
        }
    }

    // Relationship: Film *-* Actor

    public Set<Actor> getActors(){
        return actors;
    }

    public void addActor(Actor actor){
        if(this.getActors().contains(actor)) return;

        this.actors.add(actor);

        if(!actor.getFilms().contains(this)){
            actor.getFilms().add(this);
        }
    }

    // Relationship: Film 1-* Review

    public Set<Review> getReviews(){
        return reviews;
    }

    public void addReview(Review review){
        if(getReviews().contains(review)) return;
        this.reviews.add(review);
        if(review.getFilm() == null || review.getFilm().getId() != this.id){
            review.setFilm(this);
        }
    }


    // Overrides...

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;
        if(id != null && film.id != null) return Objects.equals(id, film.id);
        return title.equals(film.title);
    }

    @Override
    public int hashCode(){
        return Objects.hash(getTitle());
    }
}
