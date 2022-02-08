package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class FilterCombinationPage extends PageObject {

    String MEN_PRICE_RANGE = "//a[@href='http://168.119.186.3/men/tops-men.html?cat=17&price=%s']";
    String MEN_CATEGORY_TANK = "[href='http://168.119.186.3/men/tops-men.html?cat=17']";
    String PRODUCT_NAME = "[class='product-item-link']";

    public WebElementFacade getMenTank(){
        return $(By.cssSelector(MEN_CATEGORY_TANK));
    }

    public List<WebElementFacade> getAllTanks(){
        return findAll(By.cssSelector(PRODUCT_NAME));
    }

    public WebElementFacade getMenPriceRange(String range){
        String selector = String.format(MEN_PRICE_RANGE, range);
        return  $(By.xpath(selector));
    }
}
