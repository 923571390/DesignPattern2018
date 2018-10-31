package UndoAndRedo;

import java.util.Stack;


public class ShoppingList {
	private  static Stack<String> slist = new Stack<String>();
	//add shopping goods
	public void addGoods(String s) {
		slist.push(s);
	}
	//delete shopping goods
	public String deleGoods() {
		return slist.pop();
	}
	//get the last shopping goods
	public String getGoods() {
		return slist.peek();
	}
	//record Memento
	public Memento createMemento(){
		return new Memento(slist);
	}
	//recover
	public void reinstateMemento(Memento mem) {
		this.slist = mem.getStack();
		System.out.println(slist);
	}
}
