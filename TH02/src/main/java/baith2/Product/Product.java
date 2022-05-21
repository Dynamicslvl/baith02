package baith2.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
	@Id
    private String code;
    private String description;
    private String price;
    
    public String toString() {
    	return code + " " + description + " " + price;
    }
}
