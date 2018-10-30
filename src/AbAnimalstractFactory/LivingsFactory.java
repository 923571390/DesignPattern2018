package AbAnimalstractFactory;

import Plant.Plant;

public interface LivingsFactory {
    public Plant createPlant();
    public Animal createAnimal();
    //这是抽象工厂类，使用Abstract Factory模式
}
