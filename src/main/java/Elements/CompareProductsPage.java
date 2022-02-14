package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class CompareProductsPage extends PageObject {

    String ADD_TO_COMPARE = "//div[@class='product-addto-links']//a//span[text()='Add to Compare']";
    String VIEW_COMPARE_PAGE = "[href='http://168.119.186.3/catalog/product_compare/']";
    String PRODUCTS_TO_COMPARE = "//td[@data-th='Product']//strong//a";

    public WebElementFacade addToCompare() {
        return $(By.xpath (ADD_TO_COMPARE));
    }

    public WebElementFacade goToCompareProductsPage(){
        return $(By.cssSelector (VIEW_COMPARE_PAGE));
    }

    public List<WebElementFacade> getProductsToCompare(){
        return findAll(By.xpath (PRODUCTS_TO_COMPARE));
    }
}
