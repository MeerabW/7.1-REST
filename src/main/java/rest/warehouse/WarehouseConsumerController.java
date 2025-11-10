package rest.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tradearea.model.WarehouseData;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/consumer") // Basis-URL für alle Methoden im Controller
public class WarehouseConsumerController {

    @Autowired
    private WarehouseConsumerService consumerService;

    // GET /consumer?warehouseId=001&productName=Apfel
    @RequestMapping(method = RequestMethod.GET)
    public String showConsumer(
            @RequestParam(value="warehouseId", required=false) String warehouseId,
            @RequestParam(value="productName", required=false) String productName,
            Model model) {

        List<WarehouseData> warehouses = consumerService.getAllWarehouses();

        // Filter nach Standort
        if (warehouseId != null && !warehouseId.isEmpty()) {
            warehouses = warehouses.stream()
                    .filter(w -> w.getWarehouseID().equalsIgnoreCase("W" + warehouseId))
                    .collect(Collectors.toList());
        }

        // Filter nach Produktname
        if (productName != null && !productName.isEmpty()) {
            for (WarehouseData w : warehouses) {
                w.setProductData(
                        w.getProductData().stream()
                                .filter(p -> p.getProductName().toLowerCase().contains(productName.toLowerCase()))
                                .collect(Collectors.toList())
                );
            }
        }

        model.addAttribute("warehouses", warehouses);
        return "consumer"; // Thymeleaf Template
    }
}
