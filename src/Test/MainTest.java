package Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Action.HarvestAction;
import Action.WaterAction;
import Animal.Cow;
import Animal.Create;
import Animal.Rhizomy;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.Entity;
import Base.FarmBuilder;
import Base.SuperFarmBuilder;
import Building.Facility;
import Building.Farm;
import Building.FarmLand;
import Building.WhiteWall;
import Building.YellowWall;
import Enum.FertilizerType;
import Facade.Facade;
import Fertilizer.AdvancedFertilizer;
import Fertilizer.CommonFertilizer;
import Fertilizer.FertilizerForPlant;

import LawnMower.Adapter220V;
import LawnMower.ImportedLawnMower;
import LawnMower.PowerPort220V;
import PersonnelDepartment.Employee;
import PersonnelDepartment.Intendant;
import Plant.Bamboo;
import Plant.Grass;
import Plant.Plant;
import SecurityGuard.StoreHouseGuardian;
import StoreHouse.BambooStore;
import StoreHouse.GrassStore;
import Strategy.Purchase;
import Strategy.PurchaseStrategyA;
import Strategy.PurchaseStrategyB;
import Strategy.PurchaseStrategyC;
import UndoAndRedo.CommandManager;
import UndoAndRedo.CutCommand;
import UndoAndRedo.InsertCommand;

public class MainTest {

	private static final String Bamboo = null;

	public static void main(String[] args) {
		
		boolean quit = false;
		
		//test builder
		Scanner input = new Scanner(System.in);
		int choose;

		System.out.println("Initialize the farm");
		System.out.println("1.Common Farm   2.Super Farm");

		Director director = new Director();
		FarmBuilder farmBuilder = null;
		Farm farm;
		choose = input.nextInt();
		if (choose == 1) {
			farmBuilder = new CommonFarmBuilder();

		} else if (choose == 2) {
			farmBuilder = new SuperFarmBuilder();
		}
		director.setFarmBuilder(farmBuilder);
		director.construct();
		farm = farmBuilder.getFarm();
		System.out.println("Your farm now have these facilities:");
		farm.showFacilities();
		
		System.out.println("");
		
		// test composite
		Intendant host = new Intendant("Host");
		Intendant managingani = new Intendant("Managing animals");
		Intendant managingpla = new Intendant("Managing plants");
		host.add(managingani); 
		host.add(managingpla);
		managingani.add(new Employee("Farmer1"));
		managingpla.add(new Employee("Farmer2"));
		
		host.printList();
		
		System.out.println("");

		//test decorator
		System.out.println("\nNow you can decorate the Rhizomys House:\n" + "1.paint the wall white\n"
				+ "2.paint the wall yellow");
		choose = input.nextInt();
		if (choose == 1) {
			Facility whiteRhizomysHouse = new WhiteWall(farm.getRhizomysHouse());
			whiteRhizomysHouse.getDescription();
		} else if (choose == 2) {
			Facility yellowRhizomysHouse = new YellowWall(farm.getRhizomysHouse());
			yellowRhizomysHouse.getDescription();
		}
		
		System.out.println("");
		
		//test strategy
		System.out.println("\nWhen you sale your products, you have three strategies:");
		Purchase purchase;

		System.out.println("Strategy A:");
		purchase = new Purchase(new PurchaseStrategyA());
		purchase.doPurchaseStrategy();

		System.out.println("Strategy B:");
		purchase = new Purchase(new PurchaseStrategyB());
		purchase.doPurchaseStrategy();

		System.out.println("Strategy C:");
		purchase = new Purchase(new PurchaseStrategyC());
		purchase.doPurchaseStrategy();
		
		System.out.println("");
		
		System.out.println("Now we want to go to shop for shopping. Let's prepare our shoppinglist");

		//test command and memento
		CommandManager commandManager = new CommandManager();
		System.out.println("We want to buy one bamboo and one seed.");
		commandManager.executeCommand(new InsertCommand("bamboo"));
		commandManager.executeCommand(new InsertCommand("seed"));
		System.out.println("Now we only want one bamboo.");
		commandManager.executeCommand(new CutCommand());
		System.out.println("We regret.");		
		commandManager.undo();
		System.out.println("We regret again.");
		commandManager.redo();
		
		System.out.println("");
		
		// test Factory Method & Abstract Factory
		System.out.println("Let's buy some animals and plant now!");
		while(!quit) {
			System.out.println("Would you like to buy an animal or a plant? (Type Q to Quit) (A/P/Q)");
			Scanner in=new Scanner(System.in);
			String s=in.next();
			switch(s){
	    	case "A":
	    		System.out.println("Would you like to create a cow or a rhizomy? (C/R)");
	    		String s1=in.next();
	    		switch(s1){
	        	case "C":
	        		if(Create.cow(farm) != null) System.out.println("You have created a cow successfully!");
	        	    break;
	        	case "R":
	        		if(Create.rhizomy(farm) != null) System.out.println("You have created a rhizomy successfully!");
	        	    break;
	        	default:
	        		System.out.println("The option you entered is invalid. Please re-enter it.");
	        	    break;
	        	}
	    	    break;
	    	case "P":
	    		System.out.println("Would you like to create a grass or a bamboo? (G/B)");
	    		String s2=in.next();
	    		switch(s2){
	        	case "G":
	        		if(Create.grass(farm) != null) System.out.println("You have created a grass successfully!");
	        	    break;
	        	case "B":
	        		if(Create.bamboo(farm) != null) System.out.println("You have created a bamboo successfully!");
	        	    break;
	        	default:
	        		System.out.println("The option you entered is invalid. Please re-enter it.");
	        	    break;
	        	}
	    	    break;
	    	case "Q":
	    		quit = true;
	    		break;
	    	default:
	    		System.out.println("The option you entered is invalid. Please re-enter it.");
	    	    break;
	    	} 
		}
		
		System.out.println("");

//		//have created grass and bamboo
//		Plant bamboo = Create.bamboo(farm);
//		Plant grass = Create.grass(farm);
		
		// test Visitor & Observer
		System.out.println("Let's water that bamboo~");
		WaterAction visitor = new WaterAction();
		FarmLand bambooLand = farm.getBigFarmLand().getFarmLand("Bamboo Farmland");
		bambooLand.runAction(visitor);
		System.out.println("Let's check the humidity of bamboo.");
		bambooLand.checkHumidity();
		
		System.out.println("How about grass?");
		FarmLand grassLand = farm.getBigFarmLand().getFarmLand("Grass Farmland");
		if(!grassLand.checkHumidity()) {
			System.out.println("Looks like we have to water the lawn as well.");
			grassLand.runAction(visitor);
		}
		
		System.out.println("");

		//test prototype and bridge
		System.out.println("We have to fertilize the plant");
		//register in prototype
		FertilizerForPlant.addPrototype(new CommonFertilizer(1));
		FertilizerForPlant.addPrototype(new AdvancedFertilizer(1));
		
		//test prototype
		FertilizerForPlant f1 = FertilizerForPlant.findAndClone(FertilizerType.COMMON);
		FertilizerForPlant f2 = FertilizerForPlant.findAndClone(FertilizerType.ADVANCED);

		System.out.println("");

		//test bridge
		while(true) {
			System.out.println("How many bamboos do you want to use advanced fertilize?");
			Scanner inbamNum=new Scanner(System.in);
			int bamFertNum = inbamNum.nextInt();
			
			int n1 = 0;
			ArrayList<Entity> bamEntities = farm.getBigFarmLand().getFarmLand("Bamboo Farmland").getEntities();
			
			if(bamFertNum > bamEntities.size()) {
				System.out.println("We don't have that much bamboo at all!");
				continue;
			}
			
			Iterator iter = bamEntities.iterator();
			while(iter.hasNext() && n1 < bamFertNum) {
				++n1;
				f2.fertilizing((Plant)iter.next());
			}
			break;
		}
		
		while(true) {
			System.out.println("How many grass do you want to use common fertilize?");
			Scanner ingrasNum=new Scanner(System.in);
			int grasFertNum = ingrasNum.nextInt();
			int n2 = 0;
			ArrayList<Entity> grasEntities = farm.getBigFarmLand().getFarmLand("Grass Farmland").getEntities();
			
			if(grasFertNum > grasEntities.size()) {
				System.out.println("We don't have that much grass at all!");
				continue;
			}
			
			Iterator iter1 = grasEntities.iterator();
			while(iter1.hasNext() && n2 < grasFertNum) {
				++n2;
				f1.fertilizing((Plant) iter1.next());
			}
			break;
		}
		
		
		System.out.println("");

		// test Facade
		Facade facade = new Facade();
		quit = false;
		while(!quit) {
			System.out.println("\nYou can check the number of plants:\n"+  "A.check the number of plants"
					+ " B.check the number of bamboo"+" C.check the number of Grass"+" Q.quit");
			Scanner in=new Scanner(System.in);
			String s=in.next();
			switch(s){
	    	case "A":
	    		facade.printPlantNum(farm);
	    		
	    	    break;
	    	case "B":
	    		facade.printBambNum(farm);
	    	    break;
	    	case "C":
	    		facade.printGrassNum(farm);
	    	    break;
	    	
	    	case "Q":
	    		quit = true;
	    		break;
	    	default:
	    		System.out.println("The option you entered is invalid. Please re-enter it.");
	    	    break;
	    	} 
		}
		
		System.out.println("");

		// test Visitor again
		System.out.println("Now that some crops are ripe, let's harvest them.");
		HarvestAction harvestVisitor = new HarvestAction();
		GrassStore grassStore = GrassStore.getInstance();
		BambooStore bambooStore = BambooStore.getInstance();
		
		bambooLand.runAction(harvestVisitor);
		bambooStore.printSum();
		
		grassLand.runAction(harvestVisitor);
		grassStore.printSum();
		
		System.out.println("");

		// test Mediator & Chain Of Responsibility & State (仓库减少应该会有打印！)
		System.out.println("The animals are hungry too. We should feed them right away.");
		if(farm.getCowshed().getEntitiesNum() > 0) {
			System.out.println("Ops! Some animals are sick!");
			Cow cow = (Cow) farm.getCowshed().getEntities().get(0);
			cow.ill();
			farm.getCowshed().feedAnimals(farm);
		}
		else {
			System.out.println("There is no cow in the cow shed.");
		}
		
		if(farm.getRhizomysHouse().getEntitiesNum() > 0) {
			farm.getRhizomysHouse().feedAnimals(farm);
		}
		else {
			System.out.println("There is no Rhizomy in the Rhizomy house.");
		}		
		
		System.out.println("");

		// test proxy
		System.out.println("Let's test the security system of our new farm.");
		StoreHouseGuardian guardian = new StoreHouseGuardian("guardian", 0);
		guardian.setAlarm();
				
		guardian.checkFeedable(farm.getBigFarmLand().getFarmLand("Bamboo Farmland"));
				
		System.out.println("");

		// test adapter
		System.out.println("There are too many weeds on the new farm!");
				
		ImportedLawnMower lawnMower = new ImportedLawnMower();
		PowerPort220V powerport = new PowerPort220V();
		lawnMower.charge110V(powerport.output220v());
				
		System.out.println("Oh! We can not use 220V at all! Let's convert it to 110V!");
				
		Adapter220V adapter = new Adapter220V();
		lawnMower.charge110V((adapter.Convert220vTo110V()));
		
		System.out.println("");
		
		// end
		System.out.println("Today is too fulfilling, take a rest early!");
		
	}

}
