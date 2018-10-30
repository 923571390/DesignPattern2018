package Mediator;

import java.util.Iterator;

import AbAnimalstractFactory.Animal;
import Base.Farm;
import Base.House;
import ChainOfPesponsibility.BambooStore;
import ChainOfPesponsibility.GrassStore;
import ChainOfPesponsibility.StoreHouse;

public class Feeder extends Mediator{

	public StoreHouse whatToEat(House animalhouse) {
		// TODO Auto-generated method stub
		if (animalhouse.getName() == "Cow House" ) return GrassStore.getInstance();
		else if (animalhouse.getName() == "Rhizomys House") return BambooStore.getInstance();
		else return null;
	}

	@Override
	public void feed(House animalhouse, Farm farm) {
		// TODO Auto-generated method stub
		StoreHouse storage = whatToEat(animalhouse); //找到动物对应的仓库
		if (storage.getName()=="Bamboo Store") {
			System.out.println("Feeding bamboo to rhizomy.");
			Iterator iter = animalhouse.getEntities().iterator();
			while(iter.hasNext()) {
				if (storage.checkFeedable(farm.getBigFarmLand().getFarmLand("Bamboo Farmland"))) {
					if (!((Animal) iter).isFull()) {
						((Animal) iter).feed();  //喂食
					}
					else {
						System.out.println("The animal is already full");
					}
				}
			}
		}
		else {
			System.out.println("Feeding grass to cow.");
			Iterator iter = animalhouse.getEntities().iterator();
			while(iter.hasNext()) {
				if (storage.checkFeedable(farm.getBigFarmLand().getFarmLand("Grass Farmland"))) {
					if (!((Animal) iter).isFull()) {
						((Animal) iter).feed();  //喂食
					}
					else {
						System.out.println("The animal is already full");
					}
				}
			}
		}
	}


}//喂食器
