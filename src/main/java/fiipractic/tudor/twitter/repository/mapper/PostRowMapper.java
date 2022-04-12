package fiipractic.tudor.twitter.repository.mapper;

import fiipractic.tudor.twitter.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostRowMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Post post=new Post();

        post.setId(rs.getInt("ID"));
        post.setMessage(rs.getString("MESSAGE"));
        post.setUsername(rs.getString("USERNAME"));
        post.setTimestamp(rs.getString("TIMESTAMP"));

        return post;
    }
}
