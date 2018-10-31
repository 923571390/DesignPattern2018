package Test;

import Enum.FertilizerType;
import Fertilizer.AdvancedFertilizer;
import Fertilizer.CommonFertilizer;
import Fertilizer.FertilizerForPlant;
import Plant.Bamboo;
import Plant.Grass;
import Plant.Plant;
import UndoAndRedo.CommandManager;
import UndoAndRedo.CutCommand;
import UndoAndRedo.InsertCommand;

public class PrototypeBridgeTest {
	public static void main(String[] args) {
		Plant bamboo = new Bamboo();
		Plant grass = new Grass();
		//register in prototype
		FertilizerForPlant.addPrototype(new CommonFertilizer(1));
		FertilizerForPlant.addPrototype(new AdvancedFertilizer(1));
	
		//test prototype
		FertilizerForPlant f1 = FertilizerForPlant.findAndClone(FertilizerType.COMMON);
		FertilizerForPlant f2 = FertilizerForPlant.findAndClone(FertilizerType.COMMON);
		FertilizerForPlant f3 = FertilizerForPlant.findAndClone(FertilizerType.ADVANCED);
		FertilizerForPlant f4 = FertilizerForPlant.findAndClone(FertilizerType.ADVANCED);
		
		//test bridge
		f1.fertilizing(grass);
		f1.fertilizing(bamboo);
		f2.fertilizing(bamboo);
		f2.fertilizing(grass);
		f3.fertilizing(bamboo);
		f4.fertilizing(grass);
    }
}
