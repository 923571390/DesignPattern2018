package Base;

public class ImportedLawnMower {

	public ImportedLawnMower() {
		
	}
	
	public void charge110V(int voltage) {
		if (voltage == 110) {
			System.out.println("割草机开始工作！");
		}
		else {
			System.out.println("当前输入电压不符合割草机所需规格！");
		}
	}
}
