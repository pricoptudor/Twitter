package fiipractic.tudor.twitter.service;

import fiipractic.tudor.twitter.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    String registerUser(User user);
    User searchForUserByUsername(String username);
    List<User> searchForUserByFirstName(String firstName);
    List<User> searchForUserByLastName(String lastName);
    User loginUser(String username,String password);
    void unregisterUser();
}
