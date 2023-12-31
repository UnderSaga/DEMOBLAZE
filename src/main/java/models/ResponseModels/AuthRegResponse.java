package models.ResponseModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegResponse {
    @JsonProperty("Auth_token: dmVrYVN0ZXIxNzAyMzc1")
    public String authToken;
    public String errorMessage;
}
