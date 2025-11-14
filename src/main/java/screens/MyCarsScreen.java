package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/addCarBtn")
    AndroidElement btnAddNewCar;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;

    public void clickBtnAddNewCar(){
        clickWait(btnAddNewCar, 3);
    }
    public boolean textInPopUpMessageSuccessPresent(String text) {
        return textInElementPresent(popUpMessageSuccess, text, 3);
    }
}
