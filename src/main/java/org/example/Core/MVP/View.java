package org.example.Core.MVP;

import org.example.Core.MVP.Animals.AnimalType;
import org.example.Core.MVP.Animals.AnimalTypeHome;

public interface View {

    AnimalType getTypeAnimals();


    AnimalTypeHome getTypeAnimalsHome();

    String getName();

    String getBirthday();

    String getCommands();
}
