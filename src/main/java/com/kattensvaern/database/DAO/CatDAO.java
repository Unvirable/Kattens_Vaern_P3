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
        String sql = "SELECT cat_id, name, birthday, gender, catType, located_in, description, availability FROM cats";

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
                            rs.getString("description"),
                            rs.getString("availability")
                    );
                    cats.add(cat);
                }

        }catch (SQLException e){ e.printStackTrace();}
        return cats;
    }



   public Cat findCatById(int id) {
       String sql = "SELECT cat_id, name, birthday, gender, catType, located_in, description, availability FROM cats WHERE cat_id = ?";

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
                           rs.getString("description"),
                           rs.getString("availability")
                   );
               }
           }
       } catch (SQLException e){ e.printStackTrace();}

       return null;
   }


   public void CreateCat(Cat cat){
        String sql = "INSERT INTO cats (name, birthday, gender, cattype, located_in, description, availability) VALUES(?, ?, ?, ?, ?, ?, ?)";

       try(Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {



               stmt.setString(1, cat.getName());
               stmt.setDate(2, java.sql.Date.valueOf(cat.getBirthday()));
               stmt.setString(3, cat.getGender());
               stmt.setString(4, cat.getCatType());
           stmt.setString(5, cat.getLocatedIn());
           stmt.setString(6, cat.getDescription());
               stmt.setString(7, cat.getAvailability());

               stmt.executeUpdate();

       } catch (SQLException e){
           System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");   //temporary
           throw new RuntimeException(e);
       }





   };






    public void DeleteCat(int id){
        String sql = "DELETE FROM cats WHERE cat_id = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {



            stmt.setInt(1, id);


            stmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");   //temporary
            throw new RuntimeException(e);
        }


}




    public void UpdateCat(Cat cat){
        String sql = "UPDATE cats SET name = ?, birthday = ?, gender = ?, catType = ?, located_in = ?, description = ?, availability = ? WHERE cat_id = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {



            stmt.setString(1, cat.getName());
            stmt.setDate(2, java.sql.Date.valueOf(cat.getBirthday()));
            stmt.setString(3, cat.getGender());
            stmt.setString(4, cat.getCatType());
            stmt.setString(5, cat.getLocatedIn());
            stmt.setString(6, cat.getDescription());
            stmt.setString(7, cat.getAvailability());
            stmt.setInt(8, cat.getId());

            stmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");   //temporary
            throw new RuntimeException(e);
        }





    };








}
