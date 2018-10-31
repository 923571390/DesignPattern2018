package AnimalState;

public abstract class State {
	
	public abstract boolean isItHealthy();//能否喂食
    public abstract boolean canBeFed();//能否喂食
    
}//关于状态类的设计，我这里暂且设置为，动物会生病（哪里控制它生病的频率还不知道，用.ill()这个函数让它病），然后只有喂食的时候，才能发现生病的动物，选择不治疗它就继续病着，选择治疗则直接治好并且喂食。
