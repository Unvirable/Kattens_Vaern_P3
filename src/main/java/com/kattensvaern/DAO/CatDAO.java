package com.kattensvaern.DAO;

import com.kattensvaern.model.Cat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Handles talking with the Database
@Repository
public class CatDAO {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public CatDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cat> getAllCats(){
        String sql = "Select * From catsTest";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cat cat = new Cat(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("city"),
                    rs.getString("description")
            );
            return cat;

        });
    };
}
