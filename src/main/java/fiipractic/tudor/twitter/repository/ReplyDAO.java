package fiipractic.tudor.twitter.repository;

import fiipractic.tudor.twitter.TwitterApplication;
import fiipractic.tudor.twitter.model.Reply;
import fiipractic.tudor.twitter.repository.mapper.PostRowMapper;
import fiipractic.tudor.twitter.repository.mapper.ReplyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addReply(int id_post,boolean isPost,boolean isPublic) {
        int replyScope=1;
        if(!isPublic){
            replyScope=0;
        }

        if (isPost) {
            try {
                jdbcTemplate.queryForObject("SELECT * FROM POSTS WHERE ID=?",
                        new PostRowMapper(), id_post);
                jdbcTemplate.update("INSERT INTO REPLIES(ID_POST,USERNAME_REPLY,PUBLIC) VALUES(?,?,?)",
                        id_post, TwitterApplication.loggedUser.getUsername(),replyScope);
                return String.format("Successfully replied to post \'%d\'", id_post);
            } catch (EmptyResultDataAccessException ex) {
                return String.format("Post with id \'%d\' doesn't exist.", id_post);
            }
        }
        else{
            try {
                jdbcTemplate.queryForObject("SELECT * FROM REPLIES WHERE ID=?",
                        new ReplyRowMapper(), id_post);
                jdbcTemplate.update("INSERT INTO REPLIES(ID_REPLY,USERNAME_REPLY,PUBLIC) VALUES(?,?,?)",
                        id_post, TwitterApplication.loggedUser.getUsername(),replyScope);
                return String.format("Successfully replied to reply \'%d\'", id_post);
            } catch (EmptyResultDataAccessException ex) {
                return String.format("Reply with id \'%d\' doesn't exist.", id_post);
            }
        }
    }

    public List<Reply> getReplies(){
        try{
            return jdbcTemplate.query("SELECT * FROM REPLIES WHERE USERNAME_REPLY=TRIM(?)",
                    new ReplyRowMapper(),TwitterApplication.loggedUser.getUsername());
        }
        catch(Exception ex){
            return null;
        }
    }

    public String removeReply(int id_reply){
        try{
            jdbcTemplate.queryForObject("SELECT * FROM REPLIES WHERE ID=? AND USERNAME_REPLY=TRIM(?)",
                    new ReplyRowMapper(),id_reply,TwitterApplication.loggedUser.getUsername());

            jdbcTemplate.update("DELETE FROM REPLIES WHERE ID=?",id_reply);
            return String.format("Successfully removed post with id \'%d\'.",id_reply);
        }
        catch(EmptyResultDataAccessException ex){
            return String.format("There is no reply with id \'%d\' under current user.",id_reply);
        }
    }
}
