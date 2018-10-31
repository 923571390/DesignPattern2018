package Facade;

import Building.Farm;

//Encapsulate the subsystem
public class Facade {
	
	private Statistics countPlantNum;
	
	private Statistics countBambNum;
	
	private Statistics countGrassNum;
	
	public Facade(){
		countPlantNum = new CountPlantNum();
		countBambNum = new CountBambNum();
		countGrassNum = new CountGrassNum();
	}

	public void printPlantNum(Farm farm)
	{
		System.out.println("The number of plants in the farm is "+countPlantNum.getNum(farm));
	}
	public void printBambNum(Farm farm)
	{
		System.out.println("The number of Bamboo in the farm is "+countBambNum.getNum(farm));
	}
	public void printGrassNum(Farm farm)
	{
		System.out.println("The number of Grass in the farm is "+countGrassNum.getNum(farm));
	}
}
