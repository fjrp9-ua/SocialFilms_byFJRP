package es.socialfilms.social_films.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.socialfilms.social_films.model.Actor;
import es.socialfilms.social_films.model.Director;
import es.socialfilms.social_films.model.Film;
import es.socialfilms.social_films.model.Genre;
import es.socialfilms.social_films.model.Review;
import es.socialfilms.social_films.model.User;
import es.socialfilms.social_films.repository.ActorRepository;
import es.socialfilms.social_films.repository.DirectorRepository;
import es.socialfilms.social_films.repository.FilmRepository;
import es.socialfilms.social_films.repository.GenreRepository;
import es.socialfilms.social_films.repository.ReviewRepository;
import es.socialfilms.social_films.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Service
@Profile("dev")
public class InitDBService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @PostConstruct
    public void initDatabase(){

        // Users...
        User user1 = new User("User1");
        user1.setPassword("$2a$10$CVhvtWKFiKHGhXySz6qTO.85LLHC5.1RQgtbq0xM/YibVV6H2Sgr6");
        // user1.setPassword("12345");
        user1.setEmail("user1@gmail.com");
        userRepository.save(user1);

        // Genre...
        Genre drama = new Genre("Drama");
        genreRepository.save(drama);
        
        Genre mafia = new Genre("Mafia");
        genreRepository.save(mafia);

        // Actor...

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Actor actor1 = new Actor("Marlon", "Brando");
        actor1.setCountry("United States");
        // actor1.setBorn(sdf.parse("1924-04-03"));
        actorRepository.save(actor1);

        Actor actor2 = new Actor("Alfredo James", "Pacino");
        actor2.setCountry("United States");
        // actor1.setBorn(sdf.parse("1924-04-03"));
        actorRepository.save(actor2);

        // Director...
        Director director1 = new Director("Francis", "Ford Coppola");
        director1.setCountry("United States");
        directorRepository.save(director1);

        // Film...
        Film film1 = new Film("The Godfather");
        film1.setCountry("United States");
        film1.setSynopsis("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        film1.setRunningTime(175);
        film1.setReleaseYear(1972);
        film1.setDirector(director1);
        film1.addActor(actor1);
        film1.addActor(actor2);
        film1.addGenre(drama);
        film1.addGenre(mafia);

        Film film2 = new Film("The Godfather: Part II");
        film2.setCountry("United States");
        film2.setSynopsis("The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.");
        film2.setRunningTime(202);
        film2.setReleaseYear(1974);
        film2.setDirector(director1);
        film2.addActor(actor1);
        film2.addActor(actor2);
        film2.addGenre(drama);
        film2.addGenre(mafia);

        filmRepository.save(film1);
        filmRepository.save(film2);

        Review review1 = new Review("Great movie", 5);
        review1.setUser(user1);
        review1.setFilm(film1);
        reviewRepository.save(review1);
        film1.addReview(review1);

        Review review2 = new Review("Great movie", 4);
        review2.setUser(user1);
        review2.setFilm(film1);
        reviewRepository.save(review2);
        film1.addReview(review2);

        
    }
}
