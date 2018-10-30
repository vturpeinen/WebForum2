package fi.academy.oauthkokeilu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

@Service
public class ForumDAO {
    private JdbcTemplate jdbc;
    private RowMapper<Viestit> mapperi = (ResultSet rs, int indeksi) -> {
        Viestit viestit = new Viestit(rs.getString("content"), rs.getString("label"),rs.getInt("id"),
                rs.getDate("timestamp"));

        return viestit;
    };
    @Autowired
    public ForumDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public List<Viestit> haeKaikkiViestit() {
        List<Viestit> viestit = jdbc.query("SELECT * FROM messages", mapperi);
        return viestit;
    }
}
