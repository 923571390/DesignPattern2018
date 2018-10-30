package mediator;

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
		StoreHouse storage = whatToEat(animalhouse);//找到动物对应的仓库
		if (storage.getName()=="Bamboo Store") {
			storage.checkFeedable(farm.getBigFarmLand().getFarmLand("Bamboo Farmland"));//查看仓库里有没有，有就直接喂，没有就去地里……

		}
		else {
			storage.checkFeedable(farm.getBigFarmLand().getFarmLand("Grass Farmland"));//查看仓库里有没有，有就直接喂，没有就去地里……
		}
	}


}//喂食器
