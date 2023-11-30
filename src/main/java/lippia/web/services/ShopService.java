package lippia.web.services;

import com.crowdar.core.PropertyManager;
import com.crowdar.core.actions.ActionManager;
import com.crowdar.core.actions.WebActionManager;
import lippia.web.constants.HomeConstants;
import lippia.web.constants.ShopConstants;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import static com.crowdar.core.actions.WebActionManager.navigateTo;
import static lippia.web.utils.Utilities.*;

public class ShopService extends ActionManager {

    public static void navegarWeb() {
        navigateTo(PropertyManager.getProperty("web.base.url"));
    }

    public static void clickShopMenu() {
        WebActionManager.waitClickable(HomeConstants.SHOP_BUTTON_LOCATOR);
        clickear(HomeConstants.SHOP_BUTTON_LOCATOR);
        cerrarPopUp();
    }

    public static void viewItem() {
        WebActionManager.waitVisibility(HomeConstants.AMOUNT_LABEL_LOCATOR);
    }

    public static void addBookToBasket(String book){
        scrollToAndClickJS(ShopConstants.ELEMENT_BOOK,book);
    }

    public static void clickItemLink(){
        sleep(1000);
        WebActionManager.waitClickable(HomeConstants.AMOUNT_LABEL_LOCATOR);
        WebActionManager.click(HomeConstants.AMOUNT_LABEL_LOCATOR);
        cerrarPopUp();
    }

    public static void fillDetailsCountry(String Country){
        if ("India".equalsIgnoreCase(Country)) {
            return;
        }
        scrollTo(HomeConstants.EMAIL_INPUT_LOCATOR);
        clickear(ShopConstants.COUNTRY_SPAN_LOCATOR);
        WebActionManager.waitVisibility(ShopConstants.COUNTRY_SEARCH_INPUT_LOCATOR);
        WebActionManager.setInput(ShopConstants.COUNTRY_SEARCH_INPUT_LOCATOR, Country);
        WebActionManager.setInput(ShopConstants.COUNTRY_SEARCH_INPUT_LOCATOR, String.valueOf(Keys.ENTER));
    }

    public static void Percentage(String tax) {
        sleep(2000);
        String subSubTotal = WebActionManager.getText(ShopConstants.SUB_TOTAL_PRICE_LOCATOR);
        String numericPart = tax.replaceAll("[^0-9]", "");
        int porcentaje = Integer.parseInt(numericPart);
        int subTotal  = (int) extraerValorNumerico(subSubTotal);
        int result = (subTotal * porcentaje) / 100;
        String TaxPrice = WebActionManager.getText(ShopConstants.TAX_PRICE_LOCATOR);
        int taxes  = (int) extraerValorNumerico(TaxPrice);
        Assert.assertEquals(result, taxes);
    }
}
