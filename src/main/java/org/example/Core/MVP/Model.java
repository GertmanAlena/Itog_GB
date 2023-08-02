package org.example.Core.MVP;

import org.example.Animals.Animals;
import org.example.Client.Nursery.Nursery;

import java.util.ArrayList;
import java.util.List;

public class Model {
    Nursery currentNursery;
    public List<Animals> allAnimals;


    private String path;

    public Model() {

        this.allAnimals = allAnimals;
    }
    public Nursery currentNursery() {
        return this.currentNursery;
    }
    public void addAnimal(Animals animals) {
//        allAnimals.add(animals);
        if (allAnimals == null){
            allAnimals = new ArrayList<Animals>();
            allAnimals.add(animals);
        }else{allAnimals.add(animals);}
        for (Animals animal : allAnimals){
            System.out.println(".."+ animal);
        }
    }
    public Integer createId() {
        System.out.println("----------" + allAnimals);
        if (allAnimals == null) return 1;
        else return allAnimals.size()+1;
    }
}
