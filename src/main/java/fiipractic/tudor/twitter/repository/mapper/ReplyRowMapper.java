package fiipractic.tudor.twitter.repository.mapper;

import fiipractic.tudor.twitter.model.Like;
import fiipractic.tudor.twitter.model.Reply;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReplyRowMapper implements RowMapper<Reply> {
    @Override
    public Reply mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Reply reply=new Reply();

        reply.setId(rs.getInt("ID"));
        reply.setId_post(rs.getInt("ID_POST"));
        reply.setId_reply(rs.getInt("ID_REPLY"));
        reply.setUsername_reply(rs.getString("USERNAME_REPLY"));
        reply.setIs_public(rs.getInt("PUBLIC"));

        return reply;
    }
}
