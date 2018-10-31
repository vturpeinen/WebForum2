package fi.academy.oauthkokeilu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class KayttajaDAO {

        private JdbcTemplate jdbc;
        private RowMapper<Users> mapperi = (ResultSet rs, int indeksi) -> {
            Users users = new Users(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"));

            return users;
        };
        @Autowired
        public KayttajaDAO(JdbcTemplate jdbc) {
            this.jdbc = jdbc;
        }
        public List<Users> haeKaikkiKayttajat() {
            List<Users> users = jdbc.query("SELECT * FROM users", mapperi);
            return users;
        }
        public List<Users> jokuKayttaja() {
            List<Users> users = jdbc.query("SELECT *  FROM users where id=?", mapperi);
            return users;
        }
        public int deleteById(int id) {
            return jdbc.update("DELETE * FROM users WHERE id=?",
                    new Object[] { id });
        }

        public int lisaa(Users users) {
            return jdbc.update("insert into users(name, email, username, password) " + "values(?, ?, ?, ?)",
                    new Object[] { users.getName(), users.getEmail(), users.getUsername(), users.getPassword() });
        }
    }

