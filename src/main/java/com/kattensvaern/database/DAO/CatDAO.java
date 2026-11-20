package com.kattensvaern.database.DAO;

import com.kattensvaern.database.models.Cat;
import com.kattensvaern.database.models.CatImage;
import com.kattensvaern.database.models.enums.*;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.kattensvaern.database.models.MedicalRecord;

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


   public void CreateCat(Cat cat){
        String sql = "INSERT INTO cats (name, birthday, gender, cat_type, located_in, description, availability) VALUES(?, ?, ?, ?, ?, ?, ?)";

       try(Connection conn = dataSource.getConnection();
           PreparedStatement stmt = conn.prepareStatement(sql)) {



               stmt.setString(1, cat.getName());
               stmt.setDate(2, java.sql.Date.valueOf(cat.getBirthday()));
               stmt.setObject(3, cat.getGender());
               stmt.setObject(4, cat.getCatType());
               stmt.setObject(5, cat.getLocatedIn());
               stmt.setString(6, cat.getDescription());
               stmt.setObject(7, cat.getAvailability());

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
        String sql = "UPDATE cats SET name = ?, birthday = ?, gender = ?, cat_type = ?, located_in = ?, description = ?, availability = ? WHERE cat_id = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {



            stmt.setString(1, cat.getName());
            stmt.setDate(2, java.sql.Date.valueOf(cat.getBirthday()));
            stmt.setObject(3, cat.getGender());
            stmt.setObject(4, cat.getCatType());
            stmt.setObject(5, cat.getLocatedIn());
            stmt.setString(6, cat.getDescription());
            stmt.setObject(7, cat.getAvailability());
            stmt.setInt(8, cat.getId());

            stmt.executeUpdate();

        } catch (SQLException e){
            System.out.println("SOMETHINGS WRONG AAAAAAAAAAAH");   //temporary
            throw new RuntimeException(e);
        }

    };






    public List<Cat> findCatsByOwnerEmail(String email) {

        String sql = """
            SELECT
                c.cat_id,
                c.name,
                c.birthday,
                c.gender,
                c.cat_type,
                c.located_in,
                c.description,
                c.availability
            FROM cats c
            JOIN adoptionRecord ar ON c.cat_id = ar.cat_id
            JOIN users u ON ar.user_id = u.user_id
            JOIN userInfo ui ON u.user_id = ui.user_id
            WHERE LOWER(ui.email) = LOWER(?)
            ORDER BY c.name
            """;

        List<Cat> cats = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    cats.add(mapRow(rs));
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(
                "Failed to load adopted cats", e
            );
        }

        return cats;
    }


    public List<MedicalRecord> findMedicalRecordsByCatAndOwner(
            int catId, String email) {

        String sql = """
            SELECT
                mr.medical_record_id,
                mr.cat_id,
                mr.record_type,
                mr.description,
                mr.next_dueDate
            FROM medicalRecord mr
            JOIN adoptionRecord ar ON mr.cat_id = ar.cat_id
            JOIN users u ON ar.user_id = u.user_id
            JOIN userInfo ui ON u.user_id = ui.user_id
            WHERE mr.cat_id = ?
            AND LOWER(ui.email) = LOWER(?)
            ORDER BY mr.next_dueDate
            """;

        List<MedicalRecord> records = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, catId);
            stmt.setString(2, email);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    MedicalRecord record = new MedicalRecord(
                        rs.getInt("medical_record_id"),
                        rs.getInt("cat_id"),
                        rs.getString("record_type"),
                        rs.getString("description"),
                        rs.getObject("next_dueDate", LocalDate.class)
                    );

                    records.add(record);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(
                "Failed to load medical records", e
            );
        }

        return records;
    }

    public CatImage getCatImage(int id){
        String sql = "SELECT content_type, data FROM catimages WHERE cat_id = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return new CatImage(
                            rs.getString("content_type"),
                            rs.getBytes("data")
                    );

                }
            }
        } catch (SQLException e){ e.printStackTrace();}

        return null;

    }

}
