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

    @FindBy(xpath = "//*[@text='My Cars' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnMyCars;
    @FindBy(xpath = "//*[@text='Logout' and @resource-id='com.telran.ilcarro:id/title']")
    AndroidElement btnLogout;

    public void clickBtnLogout(){
        clickWait(btnLogout, 3);
    }
    public void clickBtnMyCars(){
        clickWait(btnMyCars, 3);
    }

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

    public boolean isElementPresent_BtnLogin(String text){
        return textInElementPresent(btnLogin, text, 3);
    }
}
