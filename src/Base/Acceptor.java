package Base;

import Action.VisitorAction;

public interface Acceptor {

	public abstract void runAction(VisitorAction visitor);

}
