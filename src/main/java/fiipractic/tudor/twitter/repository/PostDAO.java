package fiipractic.tudor.twitter.repository;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.exception.IncorrectPostException;
import fiipractic.tudor.twitter.exception.PostNotFoundException;
import fiipractic.tudor.twitter.exception.UserNotFoundException;
import fiipractic.tudor.twitter.model.Post;
import fiipractic.tudor.twitter.repository.mapper.MentionRowMapper;
import fiipractic.tudor.twitter.repository.mapper.PostRowMapper;
import fiipractic.tudor.twitter.repository.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addPost(String message){
        try {
            jdbcTemplate.update("INSERT INTO POSTS(MESSAGE,USERNAME,TIMESTAMP) VALUES(?,?,CURDATE())",
                    message, TwitterApplication.loggedUser.getUsername());
            return "Post successfully uploaded.";
        }
        catch(Exception ex){
            return "Incorrect post format.";
        }
    }

    public List<Post> getPosts(String timestamp){
        try {
            return jdbcTemplate.query("SELECT * FROM POSTS WHERE USERNAME=TRIM(?) AND TIMESTAMP>STR_TO_DATE(?,'%Y-%m-%d')",
                    new PostRowMapper(), TwitterApplication.loggedUser.getUsername(), timestamp);
        }
        catch(Exception ex){
            throw new IncorrectPostException("Either incorrect date filter(year-month-day) or no posts found on current user.");
        }
    }

    public List<Post> getFeed(){
        try{
            return jdbcTemplate.query("SELECT * FROM POSTS WHERE USERNAME IN (SELECT USERNAME2 FROM FOLLOW WHERE USERNAME1=TRIM(?))",
                    new PostRowMapper(),TwitterApplication.loggedUser.getUsername());
        }
        catch(Exception ex){
            throw new IncorrectPostException("Something is wrong while fetching feed.");
        }
    }

    public String deletePost(Integer id){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=? AND USERNAME=TRIM(?)",
                    new PostRowMapper(),id,TwitterApplication.loggedUser.getUsername());
            jdbcTemplate.update("DELETE FROM POSTS WHERE ID=? AND USERNAME=TRIM(?)",id,TwitterApplication.loggedUser.getUsername());
            return String.format("Post with id \'%d\' succesfully deleted.",id);
        }
        catch(EmptyResultDataAccessException ex){
            throw new PostNotFoundException(String.format("Post with id \'%d\' was not found in current user list.",id));
        }
    }

    public String repost(Integer id){
        try{
            Post post = jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=?",new PostRowMapper(),id);
            jdbcTemplate.update("INSERT INTO POSTS(MESSAGE,USERNAME,TIMESTAMP) VALUES(?,?,CURDATE())",
                    post.getMessage(),TwitterApplication.loggedUser.getUsername());
            return "Successfully reposted, please check posts.";
        }
        catch (EmptyResultDataAccessException ex){
            throw new PostNotFoundException(String.format("Post with id \'%d\' was not found.",id));
        }
    }

    public String mention(Integer id_post,String username){
        try {
            jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME=TRIM(?)", new UserRowMapper(), username);
        }
        catch(EmptyResultDataAccessException ex){
            throw new UserNotFoundException(String.format("User with username \'%s\' was not found",username));
        }

        try{
            jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=? AND USERNAME=TRIM(?)",
                    new PostRowMapper(),id_post,TwitterApplication.loggedUser.getUsername());

            try{
                jdbcTemplate.queryForObject("SELECT * FROM MENTIONS WHERE ID_POST=? AND USERNAME_MENTIONED=TRIM(?)",
                        new MentionRowMapper(),id_post,username);

                return String.format("User \'%s\' already mentioned in post \'%d\'.",username,id_post);
            }
            catch(EmptyResultDataAccessException ex){
                jdbcTemplate.update("INSERT INTO MENTIONS(ID_POST,USERNAME_MENTIONED) VALUES(?,?)",id_post,username);
                return String.format("User \'%s\' succesfully mentioned.",username);
            }
        }
        catch(EmptyResultDataAccessException ex){
            throw new PostNotFoundException(String.format("Post with id \'%d\' inexistent under current user.",id_post));
        }
    }

    public String getMentions(int id_post){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=? AND USERNAME=TRIM(?)",
                    new PostRowMapper(),id_post,TwitterApplication.loggedUser.getUsername());

            List<String> mentionList=new ArrayList<>();
            mentionList = jdbcTemplate.queryForList("SELECT USERNAME_MENTIONED FROM MENTIONS WHERE ID_POST=?",String.class,id_post);

            return mentionList.toString();
        }
        catch(EmptyResultDataAccessException ex){
            throw new PostNotFoundException(String.format("Post with id \'%d\' doesn't exist in current user list.",id_post));
        }
        catch(NullPointerException ex){
            return "The post has no mentions yet :p";
        }
    }

    public List<Post> getPostsMentioned(){
        try {
            return jdbcTemplate.query("SELECT * FROM POSTS WHERE ID IN (SELECT ID_POST FROM MENTIONS WHERE USERNAME_MENTIONED=TRIM(?))",
                    new PostRowMapper(),TwitterApplication.loggedUser.getUsername());
        }
        catch(Exception ex){
            throw new IncorrectPostException("Maybe you are not mentioned *sad_face*.");
        }
    }

    public String removeMention(Integer id_post,String username){
        try {
            jdbcTemplate.queryForObject("SELECT * FROM USERS WHERE USERNAME=TRIM(?)", new UserRowMapper(), username);
        }
        catch(EmptyResultDataAccessException ex){
            throw new UserNotFoundException(String.format("User with username \'%s\' was not found",username));
        }

        try{
            jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=? AND USERNAME=TRIM(?)",
                    new PostRowMapper(),id_post,TwitterApplication.loggedUser.getUsername());

            try{
                jdbcTemplate.queryForObject("SELECT * FROM MENTIONS WHERE ID_POST=? AND USERNAME_MENTIONED=TRIM(?)",
                        new MentionRowMapper(),id_post,username);

                jdbcTemplate.update("DELETE FROM MENTIONS WHERE ID_POST=? AND USERNAME_MENTIONED=TRIM(?)",
                        id_post,username);

                return String.format("User \'%s\' unmentioned from post \'%d\'.",username,id_post);
            }
            catch(EmptyResultDataAccessException ex){
                return String.format("User \'%s\' is not mentioned in post \'%d\'.",username,id_post);
            }
        }
        catch(EmptyResultDataAccessException ex){
            throw new PostNotFoundException(String.format("Post with id \'%d\' inexistent under current user.",id_post));
        }
    }
}
