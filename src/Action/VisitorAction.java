package Action;
import Base.FarmLand;
import ChainOfPesponsibility.*;

public interface VisitorAction {

	public void visit(StoreHouse store) throws Exception;
	public void visit(FarmLand land) throws Exception;

}
