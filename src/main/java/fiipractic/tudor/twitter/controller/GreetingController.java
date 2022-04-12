package fiipractic.tudor.twitter.controller;

import fiipractic.tudor.twitter.model.UserLogin;
import fiipractic.tudor.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {
    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new UserLogin());
        return "greeting";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute UserLogin greeting, Model model) {
        model.addAttribute("greeting", greeting);
        userService.loginUser(greeting.getUsername(),greeting.getPassword());
        return "result";
    }
}
