package fiipractic.tudor.twitter.repository.mapper;

import fiipractic.tudor.twitter.model.Follow;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FollowRowMapper implements RowMapper<Follow> {

    @Override
    public Follow mapRow(final ResultSet rs, final int rowNum) throws SQLException{
        final Follow follow=new Follow();

        follow.setId(rs.getInt("ID"));
        follow.setUsername1(rs.getString("USERNAME1"));
        follow.setUsername2(rs.getString("USERNAME2"));

        return follow;
    }
}
