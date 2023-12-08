import models.RequestModels.AuthRegRequest;
import models.ResponseModels.AuthRegResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRegTests extends BaseTest{
    @Test(description = "Регистрация пользователя")
    public void userAlreadyExistTest(){
        AuthRegRequest regSuccessfulRequest = new AuthRegRequest("vekaSter", "q7123546");
        AuthRegResponse successfulRegistration = API_STEPS.userRegistration(baseURL, regSuccessfulRequest, 200);
        AuthRegResponse checkSuccessfulRegistration = new AuthRegResponse(null, "This user already exist.");
        Assert.assertEquals(successfulRegistration, checkSuccessfulRegistration);
    }

    @Test(description = "Авторизация пользователя")
    public void authSuccessfulTest(){
        AuthRegRequest authSuccessfulRequest = new AuthRegRequest("vekaSter", "q7123546");
        AuthRegResponse successfulAuthorization = API_STEPS.userAuthorization(baseURL, authSuccessfulRequest, 200);
        AuthRegResponse checkSuccessfulAuthorization = new AuthRegResponse(null, null);
        Assert.assertEquals(successfulAuthorization, checkSuccessfulAuthorization);
    }

    @Test(description = "Авторизация пользователя")
    public void authUnsuccessfulTest(){
        AuthRegRequest authSuccessfulRequest = new AuthRegRequest("veka", "q7123546");
        AuthRegResponse successfulAuthorization = API_STEPS.userAuthorization(baseURL, authSuccessfulRequest, 200);
        AuthRegResponse checkSuccessfulAuthorization = new AuthRegResponse(null, "Wrong password.");
        Assert.assertEquals(successfulAuthorization, checkSuccessfulAuthorization);
    }
}
