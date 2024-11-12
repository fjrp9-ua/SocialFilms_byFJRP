package es.socialfilms.social_films.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import es.socialfilms.social_films.dto.RegisterData;
import es.socialfilms.social_films.dto.UserData;
import es.socialfilms.social_films.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserData getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("registerData", new RegisterData());
        return "registerForm";
    }
    
    @PostMapping("/register")
    public String submitRegisterForm(RegisterData registerData){
        System.out.println(registerData.getEmail() + "-" + registerData.getUserName() + "-" + registerData.getPassword() + "-" + registerData.getConfirmPassword());
        return "login";
    }

}
