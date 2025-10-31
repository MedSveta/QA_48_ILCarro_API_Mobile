package rest_tests;

import api_rest.CarController;
import dto.CarsDto;
import dto.ErrorMessageDtoString;
import dto.ResponseMessageDto;
import io.restassured.response.Response;
import org.apache.http.protocol.ResponseServer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DeleteCarTestsRest extends CarController {
    SoftAssert softAssert = new SoftAssert();
    CarsDto cars;

    @BeforeClass
    public void getUserCarsBeforeDelete() {
        Response response = getAllUserCars();
        if (response.getStatusCode() == 200) {
            cars = response.getBody().as(CarsDto.class);
        } else
            System.out.println("status code isn't 200" +
                    response.getStatusCode());

    }

    @Test
    public void deleteCarPositiveTest() {
        if (cars.getCars().length != 0) {
            String serialNumber = cars.getCars()[0].getSerialNumber();
            Response response = deleteCarBySerialNumber(serialNumber);
            System.out.println(response.getBody().print());
            ResponseMessageDto responseMessageDto = response.getBody()
                    .as(ResponseMessageDto.class);
            softAssert.assertEquals(response.getStatusCode(),
                    200, "validate status code");
            softAssert.assertTrue(responseMessageDto.getMessage()
                            .contains("deleted successfully"),
                    "validate message");
            softAssert.assertAll();
        } else
            Assert.fail("user don't have any cars");
    }

    @Test
    public void deleteCarNegativeTest_WrongSerialNumber() {
        Response response = deleteCarBySerialNumber("serialNumber");
        ErrorMessageDtoString errorMessageDtoString = response.getBody()
                .as(ErrorMessageDtoString.class);
        System.out.println(errorMessageDtoString);
        softAssert.assertEquals(response.getStatusCode(),
                400, "validate status code");
        softAssert.assertEquals(errorMessageDtoString.getMessage(),
                "Car with serial number serialNumber not found", "validate message");
        softAssert.assertAll();
    }
}
