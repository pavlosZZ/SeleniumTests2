package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class FilterSimplePage extends PageObject {

    String SELECT_FILTER = "//div[@class='filter-options']//div//div[@data-role='title'][text()='%s']";
    String PRICE_RANGE = "//div[@data-role='content']//ol//li[@class='item']//a[@href='http://168.119.186.3/women/tops-women.html?price=%s']";
    String PRODUCT_PRICE = "//ol[@class='products list items product-items']//li[@class='item product product-item']//div//div//div[@class='price-box price-final_price']//span//span//span//span";
    String NEXT_BUTTON = "//a[@href='http://168.119.186.3/women/tops-women.html?p=2&price=30-40']";

    public WebElementFacade getFilter(String filter){
        String selector = String.format(SELECT_FILTER, filter);
        return $(By.xpath(selector));
    }

    public WebElementFacade getPriceRange(String range){
        String selector = String.format(PRICE_RANGE, range);
        return  $(By.xpath(selector));
    }

    public List<WebElementFacade> getAllprices(){
        return findAll(By.xpath(PRODUCT_PRICE));
    }

    public WebElementFacade getNextButton(){
        return $(By.xpath(NEXT_BUTTON));
    }
}
