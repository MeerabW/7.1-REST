package tradearea.warehouse;

import tradearea.model.WarehouseData;
import rest.model.ProductData;

import java.util.ArrayList;
import java.util.List;

public class WarehouseSimulation {
	
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}
    // Statisch
    private final String[][] warehouseInfo = {
            {"Wien Westbahnhof", "Europlatz 2/3", "1150", "Wien", "Austria"},
            {"Linz Bahnhof", "Bahnhofsstraße 27/9", "4020", "Linz", "Austria"},
            {"Salzburg Süd", "Alpenstraße 100", "5020", "Salzburg", "Austria"},
            {"Graz Ost", "Liebenauer Hauptstraße 45", "8041", "Graz", "Austria"}
    };

    public WarehouseData getData(String inID) {
        int index;
        index = Integer.parseInt(inID) - 1;

        // Standortdaten setzen
        WarehouseData data = new WarehouseData();
        data.setWarehouseID("W" + String.format("%03d", index + 1));
        data.setWarehouseName(warehouseInfo[index][0]);
        data.setWarehouseAddress(warehouseInfo[index][1]);
        data.setWarehousePostalCode(warehouseInfo[index][2]);
        data.setWarehouseCity(warehouseInfo[index][3]);
        data.setWarehouseCountry(warehouseInfo[index][4]);

        // Produktliste generieren
        List<ProductData> products = new ArrayList<>();

        ProductData p1 = new ProductData();
        p1.setProductID("00-" + getRandomInt(100000, 999999));
        p1.setProductName("Bio Orangensaft Sonne");
        p1.setProductCategory("Getraenk");
        p1.setProductQuantity(getRandomInt(1000, 5000));
        p1.setProductUnit("Packung 1L");
        products.add(p1);

        ProductData p2 = new ProductData();
        p2.setProductID("00-" + getRandomInt(100000, 999999));
        p2.setProductName("Bio Apfelsaft Gold");
        p2.setProductCategory("Getraenk");
        p2.setProductQuantity(getRandomInt(1000, 5000));
        p2.setProductUnit("Packung 1L");
        products.add(p2);

        ProductData p3 = new ProductData();
        p3.setProductID("01-" + getRandomInt(100000, 999999));
        p3.setProductName("Ariel Waschmittel Color");
        p3.setProductCategory("Waschmittel");
        p3.setProductQuantity(getRandomInt(200, 1000));
        p3.setProductUnit("Packung 3KG");
        products.add(p3);

        ProductData p4 = new ProductData();
        p4.setProductID("00-" + getRandomInt(100000, 999999));
        p4.setProductName("Persil Discs Color");
        p4.setProductCategory("Waschmittel");
        p4.setProductQuantity(getRandomInt(500, 2000));
        p4.setProductUnit("Packung 700G");
        products.add(p4);

        data.setProductData(products);

        return data;
    }

}
