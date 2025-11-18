package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static config.AppiumConfig.*;

public class MyCarsScreen extends BaseScreen{
    public MyCarsScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.telran.ilcarro:id/addCarBtn")
    AndroidElement btnAddNewCar;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;
    @FindBy(id = "android:id/button1")
    AndroidElement btnYes;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/myCarSerialTxt']")
    List<AndroidElement> carNumberList;

    public void clickBtnAddNewCar(){
        clickWait(btnAddNewCar, 3);
    }
    public boolean textInPopUpMessageSuccessPresent(String text) {
        return textInElementPresent(popUpMessageSuccess, text, 3);
    }

    public void  deleteCar(){
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(width/8, height/4))
                .moveTo(PointOption.point(width/8*7, height/4))
                .release().perform();
    }

    public void clickBtnYes(){
        clickWait(btnYes, 3);
    }

    public List<String> readCarsListOnScreen(){
        List<String> list = new ArrayList<>();
        for (AndroidElement el: carNumberList){
            System.out.println(el.getText());
            list.add(el.getText());
        }
        return list;
    }
}
