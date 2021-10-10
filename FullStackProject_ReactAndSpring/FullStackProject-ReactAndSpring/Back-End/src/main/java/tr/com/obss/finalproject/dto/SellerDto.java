package tr.com.obss.finalproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tr.com.obss.finalproject.model.Seller;

@Getter
@Setter
@AllArgsConstructor
public class SellerDto {
    private Long id;
    private String name;
    private String address;
    public Seller convertToRealObject(){
        return new Seller(name,address);
    }

    public static SellerDto convertToDtoObject(Seller seller){
        return new SellerDto(seller.getId(),seller.getName(),seller.getAddress());
    }
}
