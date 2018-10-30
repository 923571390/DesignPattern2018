package Mediator;

import Base.Farm;
import Base.House;
import ChainOfPesponsibility.StoreHouse;

public abstract class Mediator {

	public abstract void feed(House animalhouse, Farm farm);
}//抽象中介类
