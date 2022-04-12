package fiipractic.tudor.twitter.repository;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.exception.UserAlreadyFollowedException;
import fiipractic.tudor.twitter.exception.UserNotFollowedException;
import fiipractic.tudor.twitter.repository.mapper.FollowRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FollowDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void followUser(String username){
        try {
            jdbcTemplate.queryForObject("SELECT * FROM FOLLOW WHERE USERNAME1=TRIM(?) AND USERNAME2=TRIM(?)",
                    new FollowRowMapper(), TwitterApplication.loggedUser.getUsername(), username);
            //log.info("I am here!");
            throw new UserAlreadyFollowedException(String.format("User with username \'%s\' already follows \'%s\'.",TwitterApplication.loggedUser.getUsername(),username));
        }
        catch(EmptyResultDataAccessException ex){
            jdbcTemplate.update("INSERT INTO FOLLOW(USERNAME1,USERNAME2) VALUES(?,?)",TwitterApplication.loggedUser.getUsername(),username);
        }
    }

    public void unfollowUser(String username){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM FOLLOW WHERE USERNAME1=TRIM(?) AND USERNAME2=TRIM(?)",
                    new FollowRowMapper(),TwitterApplication.loggedUser.getUsername(),username);
            jdbcTemplate.update("DELETE FROM FOLLOW WHERE USERNAME1=TRIM(?) AND USERNAME2=TRIM(?)",TwitterApplication.loggedUser.getUsername(),username);
        }
        catch(EmptyResultDataAccessException ex){
            throw new UserNotFollowedException(String.format("User with username \'%s\' doesn't follows \'%s\'",TwitterApplication.loggedUser.getUsername(),username));
        }
    }
}
