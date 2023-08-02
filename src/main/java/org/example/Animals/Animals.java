package org.example.Animals;

import org.example.GroupIterator.GroupIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Animals implements Iterable<Animals> {

    public String name  = "Unknown";
    public Integer id;
    public String birthday;
    public String commands;
    private List<Animals> allAnimals = new ArrayList<>();

    public Animals(String name, String birthday, String commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    protected AnimalTypeHome animalTypeHome = AnimalTypeHome.NONE;
//
//    public AnimalTypeHome getAnimalTypeHome() {
//        return animalTypeHome;
//    }
//
//    public void setAnimalTypeHome(AnimalTypeHome animalTypeHome) {
//        this.animalTypeHome = animalTypeHome;
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

//    @Override
//    public String toString() {
//        return "Animals{" +
//                "name='" + name + '\'' +
//                ", birthday='" + birthday + '\'' +
//                ", commmands='" + commands + '\'' +
//                '}';
//    }
    public Iterator <Animals> iterator() {
        return new GroupIterator<>(allAnimals);
    }
}
