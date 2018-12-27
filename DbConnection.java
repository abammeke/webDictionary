package edu.cs.mum;

import java.sql.*;

public class DbConnection {
    private Connection connection;

    public DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entries",
                "root", "root");
    }

    public Connection getConnection(){
        return this.connection;
    }
}
