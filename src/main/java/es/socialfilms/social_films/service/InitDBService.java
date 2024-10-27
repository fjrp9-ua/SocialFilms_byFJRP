package es.socialfilms.social_films.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.socialfilms.social_films.model.User;
import es.socialfilms.social_films.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Service
@Profile("dev")
public class InitDBService {


    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initDatabase(){

        User user1 = new User("User1");
        user1.setPassword("12345");
        user1.setEmail("user1@gmail.com");
        userRepository.save(user1);
    }
}
