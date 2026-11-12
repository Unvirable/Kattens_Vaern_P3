package com.kattensvaern.DAO;

import com.kattensvaern.model.Cat;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
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
        String sql = "Select * From catsTest";

        List<Cat> cats = new ArrayList<>();

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

                while(rs.next()) {
                    Cat cat = new Cat(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("city"),
                            rs.getString("description")
                    );
                    cats.add(cat);
                }

        }catch (SQLException e){ e.printStackTrace();}
        return cats;
    }



   public Cat findCatById(int id) {
       String sql = "SELECT id, name, age, city, description FROM catstest WHERE id = ?";

       try(Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setInt(1,id);
           try(ResultSet rs = stmt.executeQuery()){
               if(rs.next()) {
                   return new Cat(
                           rs.getInt("id"),
                           rs.getString("name"),
                           rs.getInt("age"),
                           rs.getString("city"),
                           rs.getString("description")
                   );
               }
           }
       } catch (SQLException e){ e.printStackTrace();}

       return null;
   }
}
