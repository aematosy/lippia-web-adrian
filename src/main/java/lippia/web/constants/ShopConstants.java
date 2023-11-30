package lippia.web.constants;

public class ShopConstants {

    public static final String ADD_BASKET_SHOP_LOCATOR = "xpath:(//a[contains(text(),'Add to basket')])[1]";
    public static final String ELEMENT_BOOK = "//h3[contains(text(),'%s')]//ancestor::li//a[contains(text(),'Add to basket')]";
    public static final String YOUR_ORDER_TABLE_LOCATOR = "xpath://*[@id='order_review']/table";
    public static final String SUB_TOTAL_PRICE_LOCATOR = "xpath:(//span[@class='woocommerce-Price-amount amount'])[2]";
    public static final String TAX_PRICE_LOCATOR = "xpath:(//span[@class='woocommerce-Price-amount amount'])[3]";
    public static final String COUNTRY_SPAN_LOCATOR = "xpath://a[@class='select2-choice']";
    public static final String COUNTRY_SEARCH_INPUT_LOCATOR = "id:s2id_autogen1_search";
    public static final String EMAIL_INPUT_LOCATOR = "id:billing_email";
}
