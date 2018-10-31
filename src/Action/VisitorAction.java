package Action;
import Building.FarmLand;
import StoreHouse.*;

public interface VisitorAction {

	public void visit(StoreHouse store) throws Exception;
	public void visit(FarmLand land) throws Exception;

}
