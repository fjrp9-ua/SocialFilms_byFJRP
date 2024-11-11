package es.socialfilms.social_films.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import es.socialfilms.social_films.dto.LoginData;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        
        model.addAttribute("loginData", new LoginData());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginData loginData, Model model) {
        System.out.println(loginData.getUserName() + "-" + loginData.getPassword());
        return "redirect:/login";
    }
    
}
