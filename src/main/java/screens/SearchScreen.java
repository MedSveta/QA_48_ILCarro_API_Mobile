package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class SearchScreen extends BaseScreen{
    public SearchScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    AndroidElement btnDots;
    @FindBy(xpath = "//*[@text='Registration' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnRegistration;
    @FindBy(xpath = "//*[@text='Login' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnLogin;
    @FindBy(xpath = "//hierarchy/android.widget.Toast")
    AndroidElement popUpMessageSuccess;

    public void clickBtnDots(){
        clickWait(btnDots, 3);
    }

    public void clickBtnRegistration(){
        clickWait(btnRegistration, 3);
    }

    public void clickBtnLogin(){
        clickWait(btnLogin, 3);
    }

    public boolean textInPopUpMessageSuccessPresent(String text){
        return textInElementPresent(popUpMessageSuccess, text, 3);
    }
}
