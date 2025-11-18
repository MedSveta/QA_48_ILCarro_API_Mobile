package mobile_tests;

import config.AppiumConfig;
import dto.RegistrationBodyDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.MyCarsScreen;
import screens.SearchScreen;
import screens.SplashScreen;

import java.util.List;

public class DeleteCarTests extends AppiumConfig {
    @BeforeMethod
    public void login(){
        RegistrationBodyDto user = RegistrationBodyDto.builder()
                .username("sima_simonova370@gmail.com")
                .password("BSas124!")
                .build();
        new SplashScreen(driver).goToSearchScreen(5);
        SearchScreen searchScreen = new SearchScreen(driver);
        searchScreen.clickBtnDots();
        searchScreen.clickBtnLogin();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.typeLoginForm(user);
        loginScreen.clickBtnYalla();

        searchScreen.clickBtnDots();
        searchScreen.clickBtnMyCars();

    }

    @Test
    public void deleteCarPositiveTest(){
        MyCarsScreen myCarsScreen = new MyCarsScreen(driver);
        List<String> listBeforeDelete = myCarsScreen.readCarsListOnScreen();
        myCarsScreen.deleteCar();
        myCarsScreen.clickBtnYes();
        List<String> listAfterDelete = myCarsScreen.readCarsListOnScreen();
        Assert.assertNotEquals(listAfterDelete, listBeforeDelete);
    }
}
