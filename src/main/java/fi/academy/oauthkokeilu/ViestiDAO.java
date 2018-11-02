package fi.academy.oauthkokeilu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class ViestiDAO {
    private JdbcTemplate jdbc;
    private RowMapper<Messages> mapperi = (ResultSet rs, int indeksi) -> {
        Messages messages = new Messages(

                rs.getString("label"),
                rs.getString("content"),
                rs.getInt("id"),
                rs.getDate("ttimestamp"),
                rs.getString("ggroup"));
//                rs.getInt("userid"));


        return messages;
    };
    @Autowired
    public ViestiDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
    public List<Messages> haeKaikkiViestit() {
        List<Messages> messages = jdbc.query("SELECT * FROM messages", mapperi);
        return messages;
    }
    public List<Messages> haeKayttajanViestit() {
        List<Messages> messages = jdbc.query("SELECT *  FROM messages where userid=?", mapperi);
        return messages;
}

    public List<Messages> haeViesteistaContentilla() {
        List<Messages> messages = jdbc.query("SELECT *  FROM messages WHERE content LIKE '?%'", mapperi);
        return messages;

    }

    public int deleteById(int id) {
        return jdbc.update("DELETE FROM messages WHERE id=?",
        new Object[] { id });
    }

    public int lisaa(Messages messages) {
        return jdbc.update("INSERT INTO messages(content,label, ttimestamp, ggroup) VALUES (?,?,?,?)",
                new Object[] {messages.getContent(),messages.getLabel(), messages.getTtimestamp(), messages.getGgroup() });
    }

}