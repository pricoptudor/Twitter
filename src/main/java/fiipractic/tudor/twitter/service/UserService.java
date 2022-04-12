package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.model.User;
import fiipractic.tudor.twitter.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserDAO userRepository;

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public String registerUser(User user){
        return userRepository.createUser(user.getUsername(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),user.getBirth());
    }

    public User searchForUserByUsername(String username){
        return userRepository.searchForUserByUsername(username);
    }

    public List<User> searchForUserByFirstName(String firstName){
        return userRepository.searchForUserByFirstName(firstName);
    }

    public List<User> searchForUserByLastName(String lastName){
        return userRepository.searchForUserByLastName(lastName);
    }

    public User loginUser(String username,String password){
        User response = userRepository.loginUser(username,password);
        if(response!=null){
            TwitterApplication.loggedUser=response;
        }
        return response;
    }

    public void unregisterUser(){
        userRepository.unregisterUser(TwitterApplication.loggedUser.getUsername());
    }
}
