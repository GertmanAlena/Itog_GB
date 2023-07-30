package org.example.Core.MVP;

import org.example.Core.MVP.Animals.Animals;
import org.example.Core.MVP.Nursery.Nursery;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model {
    Nursery currentNursery;

    private String path;

    public Model(String path) {
        currentNursery = new Nursery();
        this.path = path;
    }
//    public void load() {
//        try {
//            File file = new File(path);
//            FileReader fr = new FileReader(file);
//            BufferedReader reader = new BufferedReader(fr);
//            String fname = reader.readLine();
//            while (fname != null) {
//                String name = reader.readLine();
//                String birthday = reader.readLine();
//                String commmands = reader.readLine();
//                Integer idClassAnimal = reader.read();
//                this.currentNursery.add(new Animals(name, birthday, commmands, animalTypeHome));
//                fname = reader.readLine();
//            }
//            reader.close();
//            fr.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public Nursery currentNursery() {
//        return this.currentNursery;
//    }

    public void save() {

        try (FileWriter writer = new FileWriter(path, false)) {
            for (int i = 0; i < currentNursery.count(); i++) {
                Animals animals = currentNursery.getAnimals(i);
                writer.append(String.format("%s\n", animals.name));
                writer.append(String.format("%s\n", animals.birthday));
                writer.append(String.format("%s\n", animals.commmands));
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
