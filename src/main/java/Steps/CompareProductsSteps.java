package Steps;

import Elements.CompareProductsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CompareProductsSteps {

    public CompareProductsPage compareProductsPage;

    @Step
    public void addToCompare() {
        compareProductsPage.addToCompare().click();
    }

    @Step
    public void goToComparePage() {
        compareProductsPage.goToCompareProductsPage ().click ();
    }

    @Step
    public void checkProductsIntoCompareList(List<String> productsToCompare){
        List<WebElementFacade> elements = compareProductsPage.getProductsToCompare ();
        int count = 0;
        for(WebElementFacade element : elements){
            String productName = element.getText ();
            System.out.println (productName);
            for(String name : productsToCompare){
                System.out.println (name);
                if(name.equals (productName)){
                    count ++;
                    break;
                }


            }
        }
        System.out.println (count);
        assertTrue("Something went wrong...",count==productsToCompare.size ());
    }
}
