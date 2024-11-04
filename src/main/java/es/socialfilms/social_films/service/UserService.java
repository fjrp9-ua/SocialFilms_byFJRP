package es.socialfilms.social_films.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.socialfilms.social_films.dto.UserData;
import es.socialfilms.social_films.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserData findUserById(Long id){
        return modelMapper.map(userRepository.findById(id).orElse(null), UserData.class);
    }

    public List<UserData> findAll() {
        return userRepository.findAll().stream()
            .map(user -> modelMapper.map(user, UserData.class))
            .collect(Collectors.toList());
    }
}
