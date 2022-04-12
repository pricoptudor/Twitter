package fiipractic.tudor.twitter.repository.mapper;

import fiipractic.tudor.twitter.model.Like;
import fiipractic.tudor.twitter.model.Post;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeRowMapper implements RowMapper<Like> {

    @Override
    public Like mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Like like=new Like();

        like.setId(rs.getInt("ID"));
        like.setId_post(rs.getInt("ID_POST"));
        like.setUsername_like(rs.getString("USERNAME_LIKE"));

        return like;
    }
}
