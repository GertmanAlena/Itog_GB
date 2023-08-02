package org.example.Core.MVP;


import org.example.Animals.*;
import org.example.Config;
import org.example.Core.MVP.Model;
import org.example.UI.App;
import org.example.Config.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

public class Presenter {

    private View view;
    private Model model;
    private String SQLst;
    private Config config;

    public Presenter(View view) {
        this.view = view;
        model = new Model();
    }

    public void createAnimal() throws IOException {

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
            try (Connection dbConnection = Config.connection) {

                SQLst = "INSERT INTO animalTypeHome (Name, Birthday, Commands, Genus_id) VALUES (?, ?, ?, id)";
                PreparedStatement prepSt = dbConnection.prepareStatement(SQLst);
                prepSt.setString(1, animal.getName());
                prepSt.setDate(2, Date.valueOf(animal.getBirthday()));
                prepSt.setString(3, animal.getCommands());
//                rows = prepSt.executeUpdate();
//                return rows;
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
    public boolean createTable(AnimalType animalType) {
        try(Connection conn = DriverManager.getConnection(Config.URL, Config.USER_NAME, Config.PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE animalType IF NOT EXISTS" +
                    "(Id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "Genus_name VARCHAR (20), " +
                    "Class_id INT, " +
                    "FOREIGN KEY (Class_id) REFERENCES Nursery (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                    "))";

            stmt.executeUpdate(sql);
            System.out.println("Created table " + animalType + " in given database...");
            if (animalType == AnimalType.HOME_ANIMALS){
                String sql2 = "INSERT INTO animalType (Genus_name, Class_id)" +
                        "VALUES ('Кошки', 1),\n" +
                        "('Собаки', 1),  \n" +
                        "('Хомяки', 1)";

                stmt.executeUpdate(sql2);
                System.out.println("Заполнили animalType...");
            } else {
                String sql2 = "INSERT INTO animalType (Genus_name, Class_id)" +
                        "VALUES ('Лошади', 2),\n" +
                        "('Верблюды', 2),  \n" +
                        "('Ослики', 2)";

                stmt.executeUpdate(sql2);
                System.out.println("Заполнили animalType...");
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * создание таблицы cat, dog...
     */
    public boolean createTableAnimal(AnimalTypeHome animalTypeHome) {
        try(Connection conn = DriverManager.getConnection(Config.URL, Config.USER_NAME, Config.PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE animalTypeHome IF NOT EXISTS" +
                    "(Id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "Name VARCHAR()" +
                    "Birthday DATE, " +
                    "Commands VARCHAR(50),  " +
                    "Genus_id int, " +
                    "Foreign KEY (Genus_id) REFERENCES HOME_ANIMALS (Id) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                    "))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }






}
