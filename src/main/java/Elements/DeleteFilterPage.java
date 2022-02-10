package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class DeleteFilterPage extends PageObject {

    String PRODUCT_LIST = "[class='product details product-item-details']";
    String PRICE_RANGE = "//div[@data-role='content']//ol//li[@class='item']//a[@href='http://168.119.186.3/gear/bags.html?price=%s']";
    String DELETE_FILTER = "//li[@class='item']//span[text()='%s']//following-sibling::a";

    public List<WebElementFacade> getAllProducts(){
        return findAll (By.cssSelector (PRODUCT_LIST));
    }

    public WebElementFacade getPriceRange(String range){
        String selector = String.format(PRICE_RANGE, range);
        return  $(By.xpath(selector));
    }

    public WebElementFacade deleteFilter(String filter) {
        String selector = String.format (DELETE_FILTER, filter);
        return $(By.xpath (selector));
    }
}
