package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CartPage extends PageObject {

    String CART_ELEMENT = "//a[@data-bind='attr: {href: product_url}, html: product_name'][text()='%s']";
    String CART_COUNTER = "//span[@class='counter-number']";
    String CART_LIST = "[data-role='product-item']";
    String CART_ITEMS = "[class='count']";
    String TO_CART_PAGE = "[class='action viewcart']";
    String ELEMENT_INTO_FULL_CART = "//td[@data-th='Item']//div[@class='product-item-details']//strong//a[text()='%s']";

    public WebElementFacade getCartElement(String text){
        String selector = String.format(CART_ELEMENT, text);
        return $(By.xpath(selector));
    }

    public WebElementFacade getCartCounter(){
        return $(By.xpath(CART_COUNTER));
    }

    public List<WebElementFacade> getCartElements(){
        return findAll(By.cssSelector(CART_LIST));
    }

    public WebElementFacade getCartCount(){
        return $(By.cssSelector(CART_ITEMS));
    }

    public WebElementFacade getFullCart(){
        return  $(By.cssSelector(TO_CART_PAGE));
    }

    public WebElementFacade getFullCartsElement(String element){
        String selector = String.format(ELEMENT_INTO_FULL_CART, element);
        return $(By.xpath(selector));
    }
}
