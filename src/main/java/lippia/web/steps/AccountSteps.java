package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.AccountConstants;
import lippia.web.services.AccountService;
import static lippia.web.utils.Utilities.*;

public class AccountSteps extends PageSteps {

    @When("^Click on My Account Menu$")
    public void clickAccountMenu() {
        AccountService.clickAccountMenu();
    }

    @And("^Enter username \"([^\"]*)\" in username textbox$")
    public void enterUsername(String username){
        AccountService.typeUsername(username);
    }

    @And("^Enter password \"([^\"]*)\" in the password textbox$")
    public void enterPassword(String password){
        AccountService.typePassword(password);
    }

    @When("^Click on login button$")
    public void clickLoginButton() {
        AccountService.clickLoginButton();
    }

    @And("^User must successfully login to the web page$")
    public void userIsLoggedIn() {
        verifyElementPresence(AccountConstants.ACCOUNT_DASHBOARD_LOCATOR);
    }

    @Then("Login must fail saying incorrect with message {string}.")
    public void verifyErrorMessage(String expectedErrorMessage) {
        AccountService.verifyErrorMessage(expectedErrorMessage);
    }

    @And("^Click on Logout button$")
    public void clicksOnLogoutButton(){
        AccountService.logout();
    }

    @And("^Press back button$")
    public void pressBackButton(){
        AccountService.pressBackButton();
    }

    @Then("^User shouldn't be signed in to his account$")
    public void usershouldtBeSignedIntoHisAccount(){
        AccountService.validateSignOut();
    }

    @And("^Enter an Email Address \"([^\"]*)\" in textbox$")
    public void enterValidEmailInTexbox(String email){
        AccountService.enterEmail(email);
    }

    @And("^Enter \"([^\"]*)\" in textbox$")
    public void enterPasswordInTexbox(String password){
        AccountService.enterPasswordReg(password);
    }

    @And("^Click on Register button$")
    public void clickOnRegisterButton() {
        AccountService.clickRegisterButton();
    }

    @Then("Registration must fail with a warning message {string}")
    public void verifyErrorMessageRegister(String expectedErrorMessage) {
        AccountService.verifyErrorMessageRegister(expectedErrorMessage);
    }

    @Then("^User successfully comes out from the site$")
    public void userGetsRedirectedToMyAccountPage() {
        verifyElementPresence(AccountConstants.LOGIN_TITLE_LOCATOR);
    }

    @And("^Click on Account details$")
    public void clickOnMyAccountDetailsLink() {
        AccountService.clickMyAccountDetailsLink();
    }

    @Then("^User can access the Account Details section$")
    public void userCanAccessTheAccountDetailsSection() {
        verifyElementPresence(AccountConstants.EDIT_ACCOUNT_FORM_LOCATOR);
    }


}
