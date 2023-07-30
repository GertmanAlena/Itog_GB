package org.example.Core.MVP.Nursery;

import org.example.Core.MVP.Animals.Animals;

import java.util.ArrayList;
import java.util.List;

public class Nursery {

    private List<Animals> animals;

    public Nursery() {
        animals = new ArrayList<Animals>();
    }
    public boolean add(Animals animal) {
        boolean flag = false;
        if (!animals.contains(animal)) {
            animals.add(animal);
            flag = true;
        }
        return flag;
    }
    public int count() {
        return animals.size();
    }
    public Animals getAnimals(int index) {
        return contains(index) ? animals.get(index) : null;
    }
    private boolean contains(int index) {
        return animals != null
                && animals.size() > index;
    }

}
