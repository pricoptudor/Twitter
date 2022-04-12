package fiipractic.tudor.twitter.repository;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.exception.PostNotFoundException;
import fiipractic.tudor.twitter.repository.mapper.LikeRowMapper;
import fiipractic.tudor.twitter.repository.mapper.PostRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LikeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String likePost(int id_post){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM LIKES WHERE ID_POST=? AND USERNAME_LIKE=?",
                    new LikeRowMapper(),id_post, TwitterApplication.loggedUser.getUsername());
            return String.format("Post with id \'%d\' already liked by current user.",id_post);
        }
        catch(EmptyResultDataAccessException ex){
            jdbcTemplate.update("INSERT INTO LIKES(ID_POST,USERNAME_LIKE) VALUES(?,?)",
                    id_post,TwitterApplication.loggedUser.getUsername());
            return "Post successfully liked.";
        }
    }

    public String removeLike(int id_post){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM LIKES WHERE ID_POST=? AND USERNAME_LIKE=?",
                    new LikeRowMapper(),id_post, TwitterApplication.loggedUser.getUsername());
            jdbcTemplate.update("DELETE FROM LIKES WHERE ID_POST=? AND USERNAME_LIKE=TRIM(?)",
                    id_post,TwitterApplication.loggedUser.getUsername());
            return "Like succesfully removed.";
        }
        catch(EmptyResultDataAccessException ex){
            return "Post is not liked by the current user.";
        }
    }

    public String getLikes(int id_post){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=? AND USERNAME=TRIM(?)",
                    new PostRowMapper(),id_post,TwitterApplication.loggedUser.getUsername());

            List<String> likeList=new ArrayList<>();
            likeList = jdbcTemplate.queryForList("SELECT USERNAME_LIKE FROM LIKES WHERE ID_POST=?",String.class,id_post);

            return likeList.toString();
        }
        catch(EmptyResultDataAccessException ex){
            throw new PostNotFoundException(String.format("Post with id \'%d\' doesn't exist in current user list.",id_post));
        }
        catch(NullPointerException ex){
            return "The post is not liked yet :(";
        }
    }
}
