package Steps;

import Elements.DeleteFilterPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class DeleteFilterSteps {

    public DeleteFilterPage deleteFilterPage;

    @Step
    public List<WebElementFacade> getProductsList(){
        return deleteFilterPage.getAllProducts ();
    }

    @Step
    public void selectRange(String range) {
        deleteFilterPage.getPriceRange(range).click();
    }

    @Step
    public void deleteFilter(String filter) {
        deleteFilterPage.deleteFilter(filter).click();
    }
}
