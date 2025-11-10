package rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter @Setter
public class ProductData {
    private String productID;
    private String productName;
    private String productCategory;
    private int productQuantity;
    private String productUnit;


}
