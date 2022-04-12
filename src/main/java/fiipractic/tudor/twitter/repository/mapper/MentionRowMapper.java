package fiipractic.tudor.twitter.repository.mapper;

import fiipractic.tudor.twitter.model.Mention;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MentionRowMapper implements RowMapper<Mention> {
    @Override
    public Mention mapRow(final ResultSet rs,final int rowNum) throws SQLException{
        final Mention mention=new Mention();

        mention.setId(rs.getInt("ID"));
        mention.setId_post(rs.getInt("ID_POST"));
        mention.setUsername_mentioned(rs.getString("USERNAME_MENTIONED"));

        return mention;
    }
}
