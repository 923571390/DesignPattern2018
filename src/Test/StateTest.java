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
		CommonFarmBuilder commonFarmBuilder = new CommonFarmBuilder();
		director.setFarmBuilder(commonFarmBuilder);
		director.construct();
		Farm commonFarm = commonFarmBuilder.getFarm();

    	Animal cow = Create.cow(commonFarm);//鍒涘缓濂剁墰
    	Plant.Plant grass = Create.grass(commonFarm);//鍒涘缓鑽�
    	cow.isFull();  //鏄惁鍚冮ケ
    	cow.isHealthy();  //鏄惁鍋ュ悍
    	cow.hungry();  //璁╁畠楗�
    	cow.ill();   //璁╁畠鐥�
    	cow.feed();  //鍠傞
        //杩欐槸鍔ㄧ墿鎿嶄綔锛屽杺椋熸墠浼氬彂鐜扮敓鐥咃紝纭娌荤枟鍗冲彲缁х画鍠傘��
    	
    	grass.wet();  //鏄惁婀挎鼎
    	grass.mature();//鏄惁鎴愮啛
    	grass.fertilized();//鏄惁鏂借偉
    	grass.healthstate();//鏄惁鍋ュ悍
    	grass.ill();  //浣垮畠鐢熺梾
    	grass.heal(); //鍠疯嵂
    	grass.fertilize();  //鏂借偉
    	grass.remove(); //绉婚櫎
    	//杩欐槸妞嶇墿鎿嶄綔锛堟弧瓒充竴娆℃祰姘翠竴娆℃柦鑲ワ紝浼氳嚜鍔ㄦ垚鐔燂級

	}
}
