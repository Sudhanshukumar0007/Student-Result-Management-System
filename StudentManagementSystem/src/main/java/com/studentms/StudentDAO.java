package com.studentms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // INSERT
    public void insertStudent(Student s) throws Exception {
        String sql = "INSERT INTO students (name, email, course, country) VALUES (?, ?, ?, ?)";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getCountry());
            ps.executeUpdate();
        }
    }

    // SELECT ALL
    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY id";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getString("country")
                );
                list.add(s);
            }
        }
        return list;
    }

    // SELECT BY ID
    public Student getStudentById(int id) throws Exception {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("course"),
                            rs.getString("country")
                    );
                }
            }
        }
        return null;
    }

    // UPDATE
    public void updateStudent(Student s) throws Exception {
        String sql = "UPDATE students SET name=?, email=?, course=?, country=? WHERE id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setString(4, s.getCountry());
            ps.setInt(5, s.getId());
            ps.executeUpdate();
        }
    }

    // DELETE
    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
