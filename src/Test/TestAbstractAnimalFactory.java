package Test;
import Animal.Create;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;
public class TestAbstractAnimalFactory {
	public static void main(String[] args) {
		
		Director director = new Director();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();

    	Create.cow(); //创建奶牛
    	Create.grass(commonFarm); //创建牧草
    	Create.bamboo(commonFarm); //创建竹子
    	Create.rhizomy();  //创建竹鼠
    	
	}
//public static void main() {TestAbstractAnimalFactory a = null; a.test();}  //测试主函数
}
