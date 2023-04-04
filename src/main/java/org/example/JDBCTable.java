package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTable {
    static final String DB_URL = "jdbc:mysql://localhost/Employees";
    static final String USER = "student";
    static final String PASS = "pass123!";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE Registration " +
                    "(Reg_Id INTEGER not NULL, " +
                    " FirstName VARCHAR(255), " +
                    " LastName VARCHAR(255), " +
                    " Age INTEGER, " +
                    " PRIMARY KEY ( Reg_Id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
