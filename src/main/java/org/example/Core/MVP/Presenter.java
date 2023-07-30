package org.example.Core.MVP;

import org.example.Core.MVP.Animals.AnimalType;
import org.example.Core.MVP.Animals.AnimalTypeHome;
import org.example.Core.MVP.Animals.Cats;
import org.example.Core.MVP.Animals.Dogs;

public class Presenter {

    private View view;
    private Model model;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void createAnimal() {
        ///model.load();
        AnimalType animalType = view.getTypeAnimals();
        if (animalType == AnimalType.HOME_ANIMALS){
            AnimalTypeHome animalTypeHome = view.getTypeAnimalsHome();
            if (animalTypeHome == AnimalTypeHome.CAT){
                Cats cat = new Cats(view.getName(), view.getBirthday(), view.getCommands(), animalTypeHome);
            } else if (animalTypeHome == AnimalTypeHome.DOG){
                Dogs dog = new Dogs(view.getName(), view.getBirthday(), view.getCommands(), animalTypeHome);
            }

        }
//        else AnimalTypeHome animalTypeHome = view.getTypeAnimalsHome();


//        model.currentNursery().add(
//                new Animals(view.getName(), view.getBirthday(), view.getCommands(),
//                        view.getTypeAnimals2()));
        model.save();
    }

}
