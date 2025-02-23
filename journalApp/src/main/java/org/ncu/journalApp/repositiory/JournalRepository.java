package org.ncu.journalApp.repositiory;

import org.ncu.journalApp.entity.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JournalRepository {
    private final JdbcTemplate template;

    public JournalRepository(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Journal journal) {
        String sql = "INSERT INTO japp (id, title, content) VALUES (?, ?, ?)";
        template.update(sql, journal.getId(), journal.getTitle(), journal.getContent());
    }

    public void batchInsertRecords(List<Journal> journals) {
        String sql = "INSERT INTO japp (id, title, content) VALUES (?, ?, ?)";
        template.batchUpdate(sql, journals, journals.size(), (ps, journal) -> {
            ps.setLong(1, journal.getId());
            ps.setString(2, journal.getTitle());
            ps.setString(3, journal.getContent());
        });
    }

    public List<Journal> findAll() {
        String sql = "SELECT * FROM japp";
        return template.query(sql, (rs, rowNum) -> new Journal(
                rs.getInt("ID"),
                rs.getString("Title"),
                rs.getString("Content")
        ));
    }

    public Journal findById(int id) {
        String sql = "SELECT * FROM japp WHERE id = ?";
        return template.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Journal(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("content")
        ));
    }

    public void update(Journal journal) {
        String sql = "UPDATE japp SET title = ?, content = ? WHERE id = ?";
        template.update(sql, journal.getTitle(), journal.getContent(), journal.getId());
    }


    public void deleteById(int id) {
        String sql = "DELETE FROM japp WHERE id = ?";
        template.update(sql, id);
    }

}

