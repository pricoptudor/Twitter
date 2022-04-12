package fiipractic.tudor.twitter.controller;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.model.User;
import fiipractic.tudor.twitter.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    //reminder: sa fac parolele '*****' - not anymore, e mai usor de testat asa
    @GetMapping(value="/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value="/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping(value="/search", params ="username")
    public User searchForUserByUsername(@RequestParam(required = false) String username){
        return userService.searchForUserByUsername(username);
    }

    @GetMapping(value="/search", params="firstName")
    public List<User> searchForUserByFirstName(@RequestParam(required = false) String firstName){
        return userService.searchForUserByFirstName(firstName);
    }

    @GetMapping(value="/search", params="lastName")
    public List<User> searchForUserByLastName(@RequestParam(required = false) String lastName){
        return userService.searchForUserByLastName(lastName);
    }

    @RequestMapping(value="/loginto", method = {RequestMethod.GET,RequestMethod.POST})
    public User loginUser(@RequestParam String username,@RequestParam String password){
        return userService.loginUser(username,password);
    }

    @PostMapping(value="/unregister")
    public String unregisterUser(@RequestParam String password){
        if(password.equals(TwitterApplication.loggedUser.getPassword())) {
            userService.unregisterUser();
            return "User successfully unregistered.";
        }
        else{
            return "Password provided does not match!";
        }
    }

}
