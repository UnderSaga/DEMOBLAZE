package models.ResponseModels;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataProductResponse {
    String cookie;
    Integer id;
    Integer prod_id;
}
