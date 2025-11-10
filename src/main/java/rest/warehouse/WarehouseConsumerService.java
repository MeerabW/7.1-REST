package rest.warehouse;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tradearea.model.WarehouseData;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarehouseConsumerService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<WarehouseData> getAllWarehouses() {
        List<String> ids = List.of("001","002","003","004");
        List<WarehouseData> warehouses = new ArrayList<>();
        for (String id : ids) {
            WarehouseData data = restTemplate.getForObject(
                    "http://localhost:8080/warehouse/" + id + "/json",
                    WarehouseData.class
            );
            warehouses.add(data);
        }
        return warehouses;
    }
}