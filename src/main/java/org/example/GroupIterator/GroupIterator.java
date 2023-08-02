package org.example.GroupIterator;

import java.util.Iterator;
import java.util.List;

public class GroupIterator<Animals> implements Iterator<Animals> {

    private List<Animals> animalsList;
    private int index = 0;
    public GroupIterator(List<Animals> animalsList) {
    }

    @Override
    public boolean hasNext() {
        return index < animalsList.size();
    }

    @Override
    public Animals next() {
        return animalsList.get(index++);
    }
}
