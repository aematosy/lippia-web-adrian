package lippia.web.steps;

import com.crowdar.core.PageSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lippia.web.constants.ShopConstants;
import lippia.web.services.ShopService;
import static lippia.web.utils.Utilities.*;

public class ShopSteps extends PageSteps {

    @Then("^Click on Shop Menu$")
    public void clickShopMenu() {
        ShopService.clickShopMenu();
    }

    @Then("^Click on the Add \"([^\"]*)\" To Basket button in shop page$")
    public void clickItemShopMenu(String book) throws InterruptedException {
        ShopService.addBookToBasket(book);
    }

    @And("^User can view that Book in the menu item with price$")
    public void viewItemShopMenu() {
        ShopService.viewItem();
    }

    @And("^Click on Item link to proceed to checkout page$")
    public void clickItemLink() throws InterruptedException {
        ShopService.clickItemLink();
    }

    @And("User fill his details in billing details country from: \"([^\"]*)\"$")
    public void fillDetailsCountry(String country){
        ShopService.fillDetailsCountry(country);
    }

    @Then("Validate Taxes for India and other countries: \"([^\"]*)\"$")
    public void taxesVariability(String tax){
        scrollTo(ShopConstants.YOUR_ORDER_TABLE_LOCATOR);
        ShopService.Percentage(tax);
    }
}
