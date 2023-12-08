import models.RequestModels.AuthRegRequest;
import models.RequestModels.CartRequest;
import models.ResponseModels.AuthRegResponse;
import models.ResponseModels.CartResponse;
import models.ResponseModels.DataProductResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CartTests extends BaseTest{
    @Test(description = "Добавление товара в корзину")
    public void addToCartSuccessful(){
        CartRequest cartRequest = new CartRequest(1, "dmVrYVN0ZXIxNzAyMzA4", 5, true);
        API_STEPS.addToCart(baseURL, cartRequest, 200);
    }

    @Test(description = "Получение товаров в корзине")
    public void viewCart(){
        CartRequest cartRequest = new CartRequest(null, "dmVrYVN0ZXIxMTcwMjYyOA==", null, true);
        List<DataProductResponse> resourceList = API_STEPS.viewCart(baseURL, cartRequest, 200).getItems();
        List<DataProductResponse> checkList = new ArrayList<>();
        DataProductResponse productResponse1 = new DataProductResponse("vekaSter1", 1, 1);
        checkList.add(productResponse1);
        Assert.assertEquals(checkList, resourceList);
    }

    @Test(description = "Удаление товара из корзины")
    public void deleteItemFromCart(){
        CartRequest cartRequest = new CartRequest(1, null, null, true);
        API_STEPS.deleteItemFromCart(baseURL, cartRequest, 200);
    }

    @Test(description = "Удаление товара из корзины")
    public void deleteCart(){
        CartRequest cartRequest = new CartRequest(null, "dmVrYVN0ZXIxMTcwMjYyOA==", null, true);
        String result = API_STEPS.deleteCart(baseURL, cartRequest, 200);
        Assert.assertEquals(result, "Item deleted.");
    }
}
