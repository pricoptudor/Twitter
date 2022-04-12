package fiipractic.tudor.twitter.repository;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.exception.UserAlreadyFollowedException;
import fiipractic.tudor.twitter.exception.UserNotFoundException;
import fiipractic.tudor.twitter.model.Follow;
import fiipractic.tudor.twitter.model.User;
import fiipractic.tudor.twitter.repository.mapper.FollowRowMapper;
import fiipractic.tudor.twitter.repository.mapper.UserRowMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Log
@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers(){
        return jdbcTemplate.query("SELECT * FROM USERS",new UserRowMapper());
    }

    public String createUser(String username,String firstName,String lastName,String email,String password,String birth){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME=TRIM(?)",new UserRowMapper(),username);

            return String.format("User \'%s\' already exists.",username);
        }
        catch(EmptyResultDataAccessException ex){
            try {
                jdbcTemplate.update("INSERT INTO USERS VALUES(?,?,?,?,?,STR_TO_DATE(?,'%Y-%m-%d'))", username, firstName, lastName, email, password, birth);

                return String.format("User \'%s\' successfully registered",username);
            }
            catch(Exception exception){
                return String.format("Error registering user, please check data format: 'year-month-day'.");
            }
        }
    }

    public User searchForUserByUsername(String username){
        return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME=TRIM(?)",new UserRowMapper(), username);
    }

    public List<User> searchForUserByFirstName(String firstName){
        return jdbcTemplate.query("SELECT * FROM USERS WHERE FIRST_NAME=TRIM(?)",new UserRowMapper(), firstName);
    }

    public List<User> searchForUserByLastName(String lastName){
        return jdbcTemplate.query("SELECT * FROM USERS WHERE LAST_NAME=TRIM(?)",new UserRowMapper(), lastName);
    }

    public User loginUser(String username,String password){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME=TRIM(?) AND PASSWORD=TRIM(?)",
                    new UserRowMapper(), username, password);
        }
        catch (EmptyResultDataAccessException ex) {
            throw new UserNotFoundException(String.format("User with username \'%s\' and password \'%s\' was not found.", username, password));
        }
    }

    public void unregisterUser(String username){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME=TRIM(?)",
                    new UserRowMapper(),username);
            jdbcTemplate.update("DELETE FROM USERS WHERE USERNAME=TRIM(?)",username);
        }
        catch (EmptyResultDataAccessException ex){
            throw new UserNotFoundException(String.format("User with username \'%s\' was not found.",username));
        }
    }
}
