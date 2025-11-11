package tradearea.warehouse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;

import tradearea.model.WarehouseData;

import java.util.List;

@RestController
public class WarehouseController {

    @Autowired
    private tradearea.warehouse.WarehouseService service;
	
    @RequestMapping("/")
    public String warehouseMain() {
    	String mainPage = "This is the warehouse application! (DEZSYS_WAREHOUSE_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/warehouse/001/json'>Link to warehouse/001/json</a><br/>";
        return mainPage;
    }


    @RequestMapping(value="/warehouse/{inID}/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public WarehouseData warehouseData( @PathVariable String inID ) {
        return service.getWarehouseData( inID );
    }

    @RequestMapping(value="/warehouse/{inID}/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public WarehouseData warehouseDataXml(@PathVariable String inID) {
        return service.getWarehouseData(inID);
    }
    @RequestMapping("/warehouse/all/json")
    public List<WarehouseData> getAllWarehouses() {
        return service.getAllWarehouses();
    }
}