package com.coffee;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UpdateCoffeeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root"; // change if needed

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            // 1. Display existing records
            ResultSet rs = stmt.executeQuery("SELECT * FROM coffee");

            out.println("<h2>Existing Coffee Records</h2>");
            while (rs.next()) {
                out.println(rs.getInt("id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getDouble("price") + "<br>");
            }

            // 2. Update coffee product (example: id = 1)
            String updateQuery = "UPDATE coffee SET name=?, price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(updateQuery);

            ps.setString(1, "Latte");
            ps.setDouble(2, 180.00);
            ps.setInt(3, 1); // update record with id = 1

            int rows = ps.executeUpdate();

            if (rows > 0) {
                out.println("<h3>Record updated successfully!</h3>");
            } else {
                out.println("<h3>No record found with given ID</h3>");
            }

            // 3. Display updated records
            rs = stmt.executeQuery("SELECT * FROM coffee");

            out.println("<h2>Updated Coffee Records</h2>");
            while (rs.next()) {
                out.println(rs.getInt("id") + " | "
                        + rs.getString("name") + " | "
                        + rs.getDouble("price") + "<br>");
            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}
