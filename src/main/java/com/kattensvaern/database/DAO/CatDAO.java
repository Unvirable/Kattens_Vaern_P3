package com.kattensvaern.database.DAO;

import com.kattensvaern.database.models.Cat;
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

    public List<Cat> getAllCats(){
        String sql = "Select cat_id, name, birthday, gender, catType, located_in, description From cats";

        List<Cat> cats = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

                while(rs.next()) {
                    Cat cat = new Cat(
                            rs.getInt("cat_id"),
                            rs.getString("name"),
                            rs.getObject("birthday", LocalDate.class),
                            rs.getString("gender"),
                            rs.getString("catType"),
                            rs.getString("located_in"),
                            rs.getString("description")
                    );
                    cats.add(cat);
                }

        }catch (SQLException e){ e.printStackTrace();}
        return cats;
    }



   public Cat findCatById(int id) {
       String sql = "SELECT cat_id, name, birthday, gender, catType, located_in, description FROM cats WHERE cat_id = ?";

       try(Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setInt(1,id);
           try(ResultSet rs = stmt.executeQuery()){
               if(rs.next()) {
                   return new Cat(
                           rs.getInt("cat_id"),
                           rs.getString("name"),
                           rs.getObject("birthday", LocalDate.class),
                           rs.getString("gender"),
                           rs.getString("catType"),
                           rs.getString("located_in"),
                           rs.getString("description")
                   );
               }
           }
       } catch (SQLException e){ e.printStackTrace();}

       return null;
   }
}
