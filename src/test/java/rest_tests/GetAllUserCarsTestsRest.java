package rest_tests;

import api_rest.CarController;
import dto.CarsDto;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetAllUserCarsTestsRest extends CarController {
    SoftAssert softAssert = new SoftAssert();
    CarsDto cars;

    @Test
    public void getAllUserCarsPositiveTest(){
        Response response = getAllUserCars();
        cars = response.getBody().as(CarsDto.class);
        System.out.println(cars);
        softAssert.assertEquals(response.getStatusCode(),
                200, "validate status code");
        softAssert.assertTrue(cars.getCars()[0].getManufacture().contains("Volvo"),
                "validate manufacture");
        softAssert.assertAll();
    }

    @Test
    public void getAllUserCarsNegative_WrongUrl(){
        Response response = getAllUserCarsNegative_WrongUrl(REGISTRATION_URL);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 403);
    }
}
