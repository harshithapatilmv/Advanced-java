package com.coffee;

import java.sql.*;   // ✅ REQUIRED IMPORT

public class CoffeeServlet {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root"; // change if needed

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Read existing records
            String selectQuery = "SELECT * FROM coffee";
            ResultSet rs = stmt.executeQuery(selectQuery);

            System.out.println("Existing Coffee Records:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                System.out.println(id + " | " + name + " | " + price);
            }

            // 5. Insert new record
            String insertQuery = "INSERT INTO coffee (id, name, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setInt(1, 101);
            ps.setString(2, "Cappuccino");
            ps.setDouble(3, 150.50);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("New coffee product inserted successfully!");
            }

            // 6. Close connections
            rs.close();
            stmt.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}