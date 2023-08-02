package org.example.Core.MVP;


import org.example.Animals.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import static java.sql.DriverManager.getConnection;

public class Presenter {

    private View view;
    private Model model;
    private String SQLst;

    public Presenter(View view) {
        this.view = view;
        model = new Model();
    }

    public void createAnimal() throws IOException, SQLException, ClassNotFoundException {

        AnimalType animalType = view.getTypeAnimals();
        System.out.println(animalType);
        createTable(animalType);  //создаём таблицу домашних или диких

        if (animalType == AnimalType.HOME_ANIMALS) {
            Integer classId = 1;
            AnimalTypeHome animalTypeHome = view.getTypeAnimalsHome();

            if (animalTypeHome == AnimalTypeHome.CAT) {
                Cats cat = new Cats(view.getName(), view.getBirthday(), view.getCommands());
                cat.setId(model.createId());
                System.out.println(cat);
                createTableAnimal(animalTypeHome);
                create(cat, classId);

            } else if (animalTypeHome == AnimalTypeHome.DOG) {
                Dogs dog = new Dogs(view.getName(), view.getBirthday(), view.getCommands(), animalTypeHome);
                System.out.println(dog);
//                Config.write(dog);

            }

        }
    }
    public void create(Animals animal, int id) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {

                SQLst = "INSERT INTO animalTypeHome (Name, Birthday, Commands, Genus_id) VALUES (?, ?, ?, id)";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLst);
                prepSt.setString(1, animal.getName());
                prepSt.setDate(2, Date.valueOf(animal.getBirthday()));
                prepSt.setString(3, animal.getCommands());
                prepSt.executeUpdate();

            }
         } catch (SQLException e) {
            System.out.println("...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        catch (ClassNotFoundException | IOException | SQLException ex) {
//            Logger.getLogger(PetRepository.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex.getMessage());
    }



    /**
     * создание таблицы домашних или диких питомцев
     */
    public boolean createTable(AnimalType animalType) throws SQLException, IOException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection dbConnection = getConnection()) {

                SQLst = "CREATE TABLE animalType IF NOT EXISTS" +
                        "(Id INT AUTO_INCREMENT PRIMARY KEY, " +
                        "Genus_name VARCHAR (20), " +
                        "Class_id INT, " +
                        "FOREIGN KEY (Class_id) REFERENCES Nursery (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                        "))";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLst);
                prepSt.executeUpdate(SQLst);
                System.out.println("Created table " + animalType + " in given database...");
                if (animalType == AnimalType.HOME_ANIMALS) {
                    String sql2 = "INSERT INTO animalType (Genus_name, Class_id)" +
                            "VALUES ('Кошки', 1),\n" +
                            "('Собаки', 1),  \n" +
                            "('Хомяки', 1)";

                    prepSt.executeUpdate(sql2);
                    System.out.println("Заполнили animalType...");
                } else {
                    String sql2 = "INSERT INTO animalType (Genus_name, Class_id)" +
                            "VALUES ('Лошади', 2),\n" +
                            "('Верблюды', 2),  \n" +
                            "('Ослики', 2)";

                    prepSt.executeUpdate(sql2);
                    System.out.println("Заполнили animalType...");
                }


            }
            return true;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * создание таблицы cat, dog...
     */
    public boolean createTableAnimal(AnimalTypeHome animalTypeHome) {
        try(Connection dbConnection = getConnection()) {
            SQLst = "CREATE TABLE animalTypeHome IF NOT EXISTS" +
                    "(Id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "Name VARCHAR()" +
                    "Birthday DATE, " +
                    "Commands VARCHAR(50),  " +
                    "Genus_id int, " +
                    "Foreign KEY (Genus_id) REFERENCES HOME_ANIMALS (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                    "))";

            PreparedStatement prepSt = dbConnection.prepareStatement(SQLst);
            prepSt.executeUpdate(SQLst);
            System.out.println("Created table in given database...");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static Connection getConnection() {

        Properties props = new Properties();
        try (FileInputStream fis =
                     new FileInputStream("src/Resources/database.properties")) {

            props.load(fis);
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
