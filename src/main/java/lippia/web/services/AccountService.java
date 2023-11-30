package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import com.crowdar.driver.DriverManager;
import lippia.web.constants.AccountConstants;
import org.openqa.selenium.*;
import org.testng.Assert;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.utils.Utilities.*;

public class AccountService extends ActionManager {

    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickAccountMenu() {
        WebActionManager.waitClickable(AccountConstants.MY_ACCOUNT_BUTTON_LOCATOR);
        doClick(AccountConstants.MY_ACCOUNT_BUTTON_LOCATOR);
    }

    public static void typeUsername(String username) {
        cerrarPopUp();
        WebActionManager.waitVisibility(AccountConstants.LOGIN_TITLE_LOCATOR);
        WebActionManager.setInput(AccountConstants.USERNAME_INPUT_LOCATOR, username);
    }

    public static void typePassword(String password) {
        WebActionManager.setInput(AccountConstants.PASSWORD_INPUT_LOCATOR, password);
    }

    public static void clickLoginButton() {
        WebActionManager.waitClickable(AccountConstants.LOGIN_BUTTON_LOCATOR);
        WebActionManager.click(AccountConstants.LOGIN_BUTTON_LOCATOR);
    }

    public static void verifyErrorMessage(String expectedErrorMessage) {
        String fullError = WebActionManager.getText(AccountConstants.MESSAGE_ERROR_LOCATOR);
        Assert.assertEquals(fullError, expectedErrorMessage);
    }

    public static void logout(){
        WebActionManager.waitVisibility(AccountConstants.LOGOUT_MENU_LOCATOR);
        doClick(AccountConstants.LOGOUT_MENU_LOCATOR);
        //WebActionManager.click(AccountConstants.LOGOUT_MENU_LOCATOR);
    }

    public static void pressBackButton(){
        DriverManager.getDriverInstance().navigate().back();
    }

    public static void validateSignOut(){
        Assert.assertFalse(isElementPresent(By.xpath("//a[contains(text(),'Logout')]")),
                "Aún nos encontramos dentro de la cuenta logueada.");
    }

    public static void enterEmail(String email) {
        cerrarPopUp();
        WebActionManager.waitVisibility(AccountConstants.TITLE_REGISTER_LOCATOR);
        WebActionManager.setInput(AccountConstants.EMAIL_INPUT_LOCATOR, email);
    }

    public static void enterPasswordReg(String password) {
        WebActionManager.setInput(AccountConstants.PASSWORD_REG_INPUT_LOCATOR, password);
    }

    public static void clickRegisterButton() {
        WebActionManager.waitClickable(AccountConstants.REGISTER_BUTTON_LOCATOR);
        WebActionManager.click(AccountConstants.REGISTER_BUTTON_LOCATOR);
    }

    public static void verifyErrorMessageRegister(String expectedErrorMessage) {
        String MsgefullError = WebActionManager.getText(AccountConstants.MESSAGE_ERROR_LOCATOR);
        Assert.assertEquals(MsgefullError, expectedErrorMessage);
    }

    public static void clickMyAccountDetailsLink() {
        WebActionManager.waitClickable(AccountConstants.ACCOUNT_DETAILS_LINK_LOCATOR);
        WebActionManager.click(AccountConstants.ACCOUNT_DETAILS_LINK_LOCATOR);
    }

}
