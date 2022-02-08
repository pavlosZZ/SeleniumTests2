package Steps;

import Elements.FilterCombinationPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilterCombinationSteps {

    public FilterCombinationPage filterCombinationPage;

    @Step
    public void getMenTank(){
        filterCombinationPage.getMenTank().click();
    }

    @Step
    public void checkAllProducts() {
        List<WebElementFacade> tanks = filterCombinationPage.getAllTanks();
        for(WebElementFacade element : tanks){
            String isItTank = element.getText();
            System.out.println(isItTank);
            if(isItTank.contains("Tank"))
                assertTrue(true);

        }
    }

    @Step
    public void selectRange(String range) {
        filterCombinationPage.getMenPriceRange(range).click();
    }

}
