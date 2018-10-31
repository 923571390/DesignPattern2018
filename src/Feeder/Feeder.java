package Feeder;

import java.util.Iterator;

import Animal.Animal;
import Building.Farm;
import Building.House;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;
import StoreHouse.StoreHouse;

public class Feeder extends Mediator{
	//The Feeder can be seem as the  concrete mediator here
	public StoreHouse whatToEat(House animalhouse) {
		if (animalhouse.getName() == "Cowshed" ) return GrassStore.getInstance();
		else if (animalhouse.getName() == "Rhizomys House") return BambooStore.getInstance();
		else return null;
	}

	@Override
	public void feed(House animalhouse, Farm farm) {
		StoreHouse storage = whatToEat(animalhouse); 
		//to find the corresponding storage
		if (storage.getName()=="Bamboo Store") {
			System.out.println("Feeding bamboo to rhizomy.");
			Iterator iter = animalhouse.getEntities().iterator();
			while(iter.hasNext()) {
				Animal animal = (Animal) iter.next();
				if (!animal.isFull()) {
					if (storage.checkFeedable(farm.getBigFarmLand().getFarmLand("Bamboo Farmland"))) {
						animal.feed();
						//feed the animal
						
					}
					else {
						break;
					}
				}
				else {
					System.out.println("The animal is already full");
				}
			}
		}
		else {
			System.out.println("Feeding grass to cow.");
			Iterator iter = animalhouse.getEntities().iterator();
			while(iter.hasNext()) {
				Animal animal = (Animal) iter.next();
				if (!animal.isFull()) {
					if (storage.checkFeedable(farm.getBigFarmLand().getFarmLand("Grass Farmland"))) {
						animal.feed();  //feed the animal
					}
					else {
						break;
					}
				}
				else {
					System.out.println("The animal is already full");
				}
				
			}
		}
	}


}
