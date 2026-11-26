package com.kattensvaern.database.DAO;

import com.kattensvaern.database.models.Appointment;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentsDAO {
    private final DataSource dataSource;
    public AppointmentsDAO(DataSource datasource){
        this.dataSource = datasource;
    }

    public void createAppointment(int userId, int catId, LocalDateTime appointmentTime){
        String sql = "INSERT INTO appointments (user_id, cat_id, appointment_time)" +
                " VALUES (?,?,?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, userId);
            statement.setInt(2, catId);
            statement.setTimestamp(3, Timestamp.valueOf(appointmentTime));

            statement.executeUpdate();

        }catch (SQLException e){
            if("23505".equals(e.getSQLState())){
                throw new IllegalStateException("Katten er allerede Booket idag");
            }
            throw new RuntimeException("Failed to create appointment",e);
        }
    }

    public boolean isCatBooked(int catId, LocalDate date){

        String sql = "SELECT EXISTS (SELECT 1 FROM appointments WHERE cat_id = ? AND appointment_time::date = ?)";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setInt(1,catId);
            statement.setDate(2,Date.valueOf(date));

            try(ResultSet rs = statement.executeQuery()){
                rs.next();
                return rs.getBoolean(1);
            }

        }catch (SQLException e){
            throw new RuntimeException("Failed to check if cat is booked",e);
        }
    }

    public List<Appointment> getAllAppointments(){
        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT user_id, cat_id, appointment_time FROM appointments";

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
                appointments.add(new Appointment(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("cat_id"),
                        resultSet.getTimestamp("appointment_time").toLocalDateTime()
                ));

            }
        }catch (SQLException e){
            throw new RuntimeException("Failed to fetch all appointments");

        }
        return appointments;
    }
}
