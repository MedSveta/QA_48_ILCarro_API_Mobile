package screens;

import dto.RegistrationBodyDto;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationScreen extends BaseScreen {
    public RegistrationScreen(AppiumDriver<AndroidElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegName']")
    AndroidElement fieldName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegLastName']")
    AndroidElement fieldLastName;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegEmail']")
    AndroidElement fieldEmail;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/editRegPassword']")
    AndroidElement fieldPassword;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/checkBoxAgree']")
    AndroidElement checkBox;
    @FindBy(xpath = "//*[@resource-id='com.telran.ilcarro:id/regBtn']")
    AndroidElement btnYalla;

    public void typeRegistrationForm(RegistrationBodyDto user) {
        fieldName.sendKeys(user.getFirstName());
        fieldLastName.sendKeys(user.getLastName());
        fieldEmail.sendKeys(user.getUsername());
        fieldPassword.sendKeys(user.getPassword());
    }
    public void clickCheckBox() {
        checkBox.click();
    }
    public void clickBtnYalla() {
        btnYalla.click();
    }
}
