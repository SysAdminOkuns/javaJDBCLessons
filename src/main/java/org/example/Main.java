package org.example;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. Get a connection to a database
            //Adding query string /?useSSL=false to avoid warning
            // WARN: Establishing SSL connection without server’s identity verification
            // is not recommended
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/world?useSSL=false",
                    "student", "pass123!");
            // Print out connection successful
            System.out.println("Database connection successful");
            // 2. Create a statement
            Statement stmt = con.createStatement();
            // 3. Execute SQL query
            ResultSet myResultset = stmt.executeQuery("select * from country limit 5");
            // 4. Process the result set.
            while(myResultset.next()){
                System.out.println(myResultset.getRow() + ") " + myResultset.getString("Name") + " " + myResultset.getString("Continent"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}