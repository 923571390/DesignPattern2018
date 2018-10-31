package UndoAndRedo;

import java.util.Stack;

public class Memento {
	
	private  static Stack<String> slist = new Stack<String>();
	public Memento(Stack sl){
		this.slist = sl;
	}
	public Stack getStack() {
		return slist;
	}

}
