package tr.com.obss.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tr.com.obss.finalproject.model.Product;

@Setter
@Getter
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Long price;
    public Product convertToRealObject(){
        return new Product(name, price);
    }
    public static ProductDto convertToDtoObject(Product product){
        return new ProductDto(product.getId(),product.getName(),product.getPrice());
    }
}
