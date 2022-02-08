package Steps;

import Elements.FilterSimplePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class FilterSimpleSteps {

    public FilterSimplePage filterPage;

    @Step
    public void selectFilter(String filter){
        filterPage.getFilter(filter).click();
    }

    @Step
    public void selectRange(String range) {
        filterPage.getPriceRange(range).click();
    }

    @Step
    public void checkPrices(String range){
        boolean passed = false;
        int count = 0;
        String x = range.substring(0,2);
        String y = range.substring(3);
        System.out.println(x +" "+ y);
        int min = Integer.parseInt(x);
        int max = Integer.parseInt(y);
        List<WebElementFacade> priceList = filterPage.getAllprices();
        for(WebElementFacade element : priceList){
            String price = element.getText();
            int price_num = Integer.parseInt(price.substring(1,3));
            System.out.println((price_num));
            count++;
            if((min <= price_num) && (max >= price_num)){
                passed = true;
            }
            assertTrue(passed);
        }
        System.out.println(count);
    }

    @Step
    public boolean isNextDisplayed(){
        boolean answer;
        try{
            answer = filterPage.getNextButton().isDisplayed();
            System.out.println("Hi");
        }catch (Exception e){
            answer = false;
        }

        return answer;
    }

    @Step
    public void clickNextButton(){
        filterPage.getNextButton().click();
    }
}
