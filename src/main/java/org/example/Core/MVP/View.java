package org.example.Core.MVP;

import org.example.Animals.AnimalType;
import org.example.Animals.AnimalTypeHome;

public interface View {

    AnimalType getTypeAnimals();
    String getBirthday();


    AnimalTypeHome getTypeAnimalsHome();

    String getName();



    String getCommands();
}
