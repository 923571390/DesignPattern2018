package Feeder;

import Building.Farm;
import Building.House;
import StoreHouse.StoreHouse;

public abstract class Mediator {
	//This is the abstract mediator,we use Mediator to realize the feed-animal function
	public abstract void feed(House animalhouse, Farm farm);
}
