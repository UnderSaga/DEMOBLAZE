package models.RequestModels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartRequest {
    Integer id;
    String cookie;
    Integer prod_id;
    Boolean flag;
}
