package tradearea.warehouse;

import org.springframework.stereotype.Service;
import tradearea.model.WarehouseData;

import java.util.List;
@Service
public class WarehouseService {
	
	public String getGreetings( String inModule ) {
        return "Greetings from " + inModule;
    }

    public WarehouseData getWarehouseData( String inID ) {
    	
    	tradearea.warehouse.WarehouseSimulation simulation = new tradearea.warehouse.WarehouseSimulation();
        return simulation.getData( inID );
        
    }

}