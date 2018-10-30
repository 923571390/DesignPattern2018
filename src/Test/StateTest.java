package Test;

import Animal.Animal;
import Animal.Create;
import Base.CommonFarmBuilder;
import Base.Director;
import Base.SuperFarmBuilder;
import Building.Farm;

public class StateTest {
	public static void main(String[] args) {
		
		Director director = new Director();
		SuperFarmBuilder superFarmBuilder = new SuperFarmBuilder();
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();

		director.setFarmBuilder(superFarmBuilder);
		director.construct();
		Farm superFarm = superFarmBuilder.getFarm();
		superFarm.showFacilities();
		System.out.println("");

    	Animal cow = Create.cow();//创建奶牛
    	Plant.Plant grass = Create.grass(superFarm);//创建草
    	cow.isFull();  //是否吃饱
    	cow.isHealthy();  //是否健康
    	cow.hungry();  //让它饿
    	cow.ill();   //让它病
    	cow.feed();  //喂食
        //这是动物操作，喂食才会发现生病，确认治疗即可继续喂。
    	
    	grass.wet();  //是否湿润
    	grass.mature();//是否成熟
    	grass.fertilized();//是否施肥
    	grass.healthstate();//是否健康
    	grass.ill();  //使它生病
    	grass.heal(); //喷药
    	grass.fertilize();  //施肥
    	grass.remove(); //移除
    	//这是植物操作（满足一次浇水一次施肥，会自动成熟）

	}
}
