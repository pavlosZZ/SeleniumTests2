package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;
import Steps.FilterSimpleSteps;
import Steps.FilterCombinationSteps;

@RunWith(SerenityRunner.class)
public class FilterCombinationTests {

    public String username = "roni_cost@example.com";
    public String password = "roni_cost3@example.com";
    public String customerCategory = "Men";
    public String productCategory = "Tops";
    public String filter2 = "Price";
    public String filter1 = "Category";
    public String range = "20-30";


    @Managed
    WebDriver driver;
    String URL = "http://168.119.186.3/";

    @Steps
    LoginSteps loginSteps;
    @Steps
    FilterSimpleSteps filterSteps;
    @Steps
    FilterCombinationSteps filterCombinationSteps;

    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }


    @Test
    public void filterCombination() throws InterruptedException {
        loginSteps.signIn();
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickSubmit();
        loginSteps.selectCustomerCategory(customerCategory);
        loginSteps.selectProductCategory(productCategory);
        filterSteps.selectFilter(filter1);
        filterCombinationSteps.getMenTank();
        Thread.sleep(5000);
        filterSteps.selectFilter(filter2);
        filterCombinationSteps.selectRange(range);
        boolean done = false;
        while(!done){
            filterSteps.checkPrices(range);
            filterCombinationSteps.checkAllProducts();
            done = true;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1450)", "");
            Thread.sleep(5000);
            if(filterSteps.isNextDisplayed()){
                filterSteps.clickNextButton();
                done = false;
            }
        }



    }


    @After
    public void afterTest(){
        driver.close();
    }
}
