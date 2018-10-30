package AnimalState;

import java.util.Scanner;

public class UnhealthyState extends State {

	@Override
	public boolean canBeFed() {
		
		System.out.println("这只动物生病了，吃不下饭呢，是否疗愈它并重新喂食？(Y/N)");
		Scanner in=new Scanner(System.in);
		String s=in.next();
		if(s.charAt(0)=='Y') {
			System.out.println("成功康复，胃口好好～");
			return true;
		}
		else return false;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isItHealthy() {
		// TODO Auto-generated method stub
		return false;
	}

}
