package tradearea.model;

import lombok.Getter;
import lombok.Setter;
import rest.model.ProductData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@Getter @Setter
public class WarehouseData {
	
	private String warehouseID;
	private String warehouseName;
	private String timestamp;
    private String warehouseAddress;
    private String warehousePostalCode;
    private String warehouseCity;
    private String warehouseCountry;

    @JacksonXmlElementWrapper(localName = "productData")
    @JacksonXmlProperty(localName = "product")
    private List<ProductData> productData;

    /**
	 * Constructor
	 */
	public WarehouseData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());

	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Warehouse Info: ID = %s, timestamp = %s", warehouseID, timestamp );
		return info;
	}
}
