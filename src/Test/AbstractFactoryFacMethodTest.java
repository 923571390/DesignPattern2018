package Test;
import Animal.Create;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;
public class AbstractFactoryFacMethodTest {
	public static void main(String[] args) {
		
		Director director = new Director();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();

    	Create.cow(commonFarm); //������ţ
    	Create.grass(commonFarm); //��������
    	Create.bamboo(commonFarm); //��������
    	Create.rhizomy(commonFarm);  //��������
    	
	}
}
