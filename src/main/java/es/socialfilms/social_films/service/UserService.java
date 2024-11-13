package es.socialfilms.social_films.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.socialfilms.social_films.dto.UserData;
import es.socialfilms.social_films.model.User;
import es.socialfilms.social_films.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly =  true)
    public UserData findUserById(Long id){
        return modelMapper.map(userRepository.findById(id).orElse(null), UserData.class);
    }

    @Transactional(readOnly =  true)
    public List<UserData> findAll() {
        return userRepository.findAll().stream()
            .map(user -> modelMapper.map(user, UserData.class))
            .collect(Collectors.toList());
    }

    @Transactional
    public UserData register(UserData userData){
        Optional<User> userDB = userRepository.findByUserName(userData.getUserName());
        if (userDB.isPresent()) return null;
        if (userData.getUserName() == null) return null;
        if (userData.getEmail() == null) return null;
        if (userData.getPassword() == null) return null;

        
        userData.setPassword(encodePassword(userData.getPassword()));

        User newUser = modelMapper.map(userData, User.class);
        newUser = userRepository.save(newUser);
        return modelMapper.map(newUser, UserData.class);
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }
}
