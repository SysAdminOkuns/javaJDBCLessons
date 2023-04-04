package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTableInsert {
    static final String DB_URL = "jdbc:mysql://localhost/Employees";
    static final String USER = "student";
    static final String PASS = "pass123!";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "Insert into Registration " +
                    "(FirstName,LastName,Age)" +
                    " values " +
                    "('Eric', 'Wright', 32)," +
                    "('Ken', 'Dow', 42)," +
                    "('Thomas', 'Edisson', 25)," +
                    "('Philiphs', 'Wright', 21)," +
                    "('Sam', 'Williams', 45)";

            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println(rowsAffected + " Rows inserted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
