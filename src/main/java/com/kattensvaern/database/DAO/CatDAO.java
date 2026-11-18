package com.kattensvaern.database.DAO;

import com.kattensvaern.database.models.Cat;
import com.kattensvaern.database.models.enums.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Handles talking with the Database
@Repository
public class CatDAO {
    private final DataSource dataSource;

    public CatDAO(DataSource datasource){
        this.dataSource = datasource;
    }

    private static final String COLUMNS = "cat_id, name, birthday, gender, cat_type, " +
                                          "located_in, description, availability";

    private Cat mapRow(ResultSet rs) throws SQLException {
        return new Cat(
                rs.getInt("cat_id"),
                rs.getString("name"),
                rs.getObject("birthday", LocalDate.class),
                Gender.valueOf(rs.getString("gender")),
                CatType.valueOf(rs.getString("cat_type")),
                Shelter.valueOf(rs.getString("located_in")),
                rs.getString("description"),
                Availability.valueOf(rs.getString("availability"))
        );
    }

    public List<Cat> getAllCats(){
        String sql = "SELECT " + COLUMNS + " FROM cats";

        List<Cat> cats = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

                while(rs.next()) {
                    cats.add(mapRow(rs));
                }

        }catch (SQLException e){ e.printStackTrace();}
        return cats;
    }



   public Cat findCatById(int id) {
       String sql = "SELECT " + COLUMNS + " FROM cats WHERE cat_id = ?";

       try(Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setInt(1,id);
           try(ResultSet rs = stmt.executeQuery()){
               if(rs.next()) {
                  return mapRow(rs);
               }
           }
       } catch (SQLException e){ e.printStackTrace();}

       return null;
   }
}
