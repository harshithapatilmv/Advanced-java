package com.dao;

import com.model.StudentMark;
import com.util.DatabaseUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MarkDAO {
    
    // Add new student marks
    public boolean addStudent(StudentMark student) {
        String query = "INSERT INTO StudentMarks (StudentID, StudentName, Subject, Marks, ExamDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getStudentName());
            pstmt.setString(3, student.getSubject());
            pstmt.setInt(4, student.getMarks());
            pstmt.setDate(5, student.getExamDate());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Update existing marks
    public boolean updateStudent(StudentMark student) {
        String query = "UPDATE StudentMarks SET StudentName=?, Subject=?, Marks=?, ExamDate=? WHERE StudentID=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getStudentName());
            pstmt.setString(2, student.getSubject());
            pstmt.setInt(3, student.getMarks());
            pstmt.setDate(4, student.getExamDate());
            pstmt.setInt(5, student.getStudentId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Delete student record
    public boolean deleteStudent(int studentId) {
        String query = "DELETE FROM StudentMarks WHERE StudentID=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Get all students
    public List<StudentMark> getAllStudents() {
        List<StudentMark> students = new ArrayList<>();
        String query = "SELECT * FROM StudentMarks ORDER BY StudentID";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(extractStudentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    // Search by StudentID
    public StudentMark getStudentById(int studentId) {
        String query = "SELECT * FROM StudentMarks WHERE StudentID=?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return extractStudentFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // Report: Students with marks above threshold
    public List<StudentMark> getStudentsAboveMarks(int threshold) {
        List<StudentMark> students = new ArrayList<>();
        String query = "SELECT * FROM StudentMarks WHERE Marks >= ? ORDER BY Marks DESC";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, threshold);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                students.add(extractStudentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    // Report: Students by subject
    public List<StudentMark> getStudentsBySubject(String subject) {
        List<StudentMark> students = new ArrayList<>();
        String query = "SELECT * FROM StudentMarks WHERE Subject=? ORDER BY Marks DESC";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, subject);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                students.add(extractStudentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    // Report: Top N students by marks
    public List<StudentMark> getTopNStudents(int n) {
        List<StudentMark> students = new ArrayList<>();
        String query = "SELECT * FROM StudentMarks ORDER BY Marks DESC LIMIT ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, n);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                students.add(extractStudentFromResultSet(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    private StudentMark extractStudentFromResultSet(ResultSet rs) throws SQLException {
        StudentMark student = new StudentMark();
        student.setStudentId(rs.getInt("StudentID"));
        student.setStudentName(rs.getString("StudentName"));
        student.setSubject(rs.getString("Subject"));
        student.setMarks(rs.getInt("Marks"));
        student.setExamDate(rs.getDate("ExamDate"));
        return student;
    }
}