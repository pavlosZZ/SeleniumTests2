package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class ProductPage extends PageObject {

    String PRODUCT_IMAGE = "//li[@class='item product product-item']//div//a//span//span//img[@alt='%s']";
    String PRODUCT_PRICE = "//div[@class='product-info-price']//span[@class='price']";
    String SIZE = "//div[@class='swatch-option text'][text()='%s']";
    String COLOR = "//div[@class='swatch-option color'][@option-label='%s']";
    String ADD_TO_CART = "[title='Add to Cart']";
    String CART_BUTTON = "[class='action showcart']";

    public WebElementFacade getProductByImage(String product){
        String selector = String.format(PRODUCT_IMAGE, product);
        return $(By.xpath(selector));
    }

    public WebElementFacade getProductsPrice(){
        return $(By.xpath(PRODUCT_PRICE));
    }

    public WebElementFacade getProductSize(String size){
        String selector = String.format(SIZE, size);
        return $(By.xpath(selector));
    }

    public WebElementFacade getProductColor(String color){
        String selector = String.format(COLOR, color);
        return $(By.xpath(selector));
    }

    public WebElementFacade addProductToCart(){
        return $(By.cssSelector(ADD_TO_CART));
    }

    public WebElementFacade getCartButton(){
        return $(By.cssSelector(CART_BUTTON));
    }
}
