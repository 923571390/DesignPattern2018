package Animal;

import Plant.Plant;

public interface LivingsFactory {
    public Plant createPlant();
    public Animal createAnimal();
    //This is the abstract factory class.
}
