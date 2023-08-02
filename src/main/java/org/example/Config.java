package org.example;

import org.example.Animals.AnimalType;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Config {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    String dbName = resource.getString("db.name");
    public static Connection connection;
    public static Statement statement;

    public Config() {
        this.connection = connection;
        this.statement = statement;

    }

    public static Connection getConnection() throws SQLException, IOException {

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("src/Resources/database.properties")) {

            props.load(fis);
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            return DriverManager.getConnection(url, username, password);
        }
    }

    public void createNursery() {
        try(Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE Nursery IF NOT EXISTS" +
                    "(Id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "Class_name VARCHAR(20))";

            stmt.executeUpdate(sql);
            System.out.println("Created table Nursery in given database...");
            String sql2 = "INSERT INTO Nursery (Class_name)" +
                    "VALUES ('вьючные', 'домашние')";

            stmt.executeUpdate(sql2);
            System.out.println("Заполнили Nursery...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



