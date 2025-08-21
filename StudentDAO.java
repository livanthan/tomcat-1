package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String URL  = "jdbc:mysql://localhost:3306/servlet";
    private static final String USER = "root";
    private static final String PASS = "livanthan_2907";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL driver not found", e);
        }
    }

    public void addStudent(String name, int age) {
        String sql = "INSERT INTO students(name, age) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting student", e);
        }
    }

    public List<Student> listStudents() {
        String sql = "SELECT id, name, age FROM students ORDER BY id DESC";
        List<Student> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching students", e);
        }
        return list;
    }
     public void delete(int id){
        String deleteSQL= "delete from students where id=?";
       try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
       PreparedStatement ps=conn.prepareStatement(deleteSQL)){
         ps.setInt(1, id);
         ps.executeUpdate();
       }
       catch(SQLException e){
        System.out.println("error in delete");   
       }
       System.out.println("product ID"+id+"deleted successfully.");
    }
    public void update(int id,String name, int age){
        String updateSQL= "update students set Name=?, Age=? where ID=?";
       try(Connection conn = DriverManager.getConnection(URL, USER, PASS);
       PreparedStatement ps=conn.prepareStatement(updateSQL)){
            ps.setString(1, name);
            ps.setInt(2, age);
         ps.setInt(3, id);
         ps.executeUpdate();
       }
       catch(SQLException e){
        System.out.println("error in delete");   
       }
       System.out.println("product ID"+id+"deleted successfully.");
    }
}
