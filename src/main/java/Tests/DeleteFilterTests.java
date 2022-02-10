package Tests;

import net.serenitybdd.core.pages.WebElementFacade;
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
import  Steps.DeleteFilterSteps;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class DeleteFilterTests {

    public String username = "roni_cost@example.com";
    public String password = "roni_cost3@example.com";
    public String customerCategory = "Gear";
    public String productCategory = "Bags";
    public String filter = "Price";
    public String range = "30-40";

    @Managed
    WebDriver driver;
    String URL = "http://168.119.186.3/";

    @Steps
    LoginSteps loginSteps;
    @Steps
    FilterSimpleSteps filterSteps;
    @Steps
    DeleteFilterSteps deleteFilterSteps;


    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void deleteFilterTest() throws InterruptedException {
        int expected_products = 0;
        int actual_products = 0;
        loginSteps.signIn ();
        loginSteps.enterUsername (username);
        loginSteps.enterPassword (password);
        loginSteps.clickSubmit ();
        loginSteps.selectCustomerCategory (customerCategory);
        loginSteps.selectProductCategory (productCategory);
        boolean done1 = false;
        while(!done1){
            List<WebElementFacade> productListBeforeDel = deleteFilterSteps.getProductsList();
            expected_products += productListBeforeDel.size ();
            done1 = true;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1450)", "");
            if(filterSteps.isNextDisplayed()){
                filterSteps.clickNextButton();
                done1 = false;
            }
        }
        System.out.println (expected_products);
        Thread.sleep (2000);
        filterSteps.selectFilter(filter);
        deleteFilterSteps.selectRange (range);
        deleteFilterSteps.deleteFilter(filter);
        Thread.sleep (2000);
        boolean done2 = false;
        while(!done2){
            List<WebElementFacade> productListAfterDel = deleteFilterSteps.getProductsList ();
            actual_products += productListAfterDel.size ();
            done2 = true;
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1450)", "");
            if(filterSteps.isNextDisplayed()){
                filterSteps.clickNextButton();
                done2 = false;
            }
        }
        System.out.println (actual_products);
        assertTrue("Something went wrong. The number of products is not the same after filter's deletion.",expected_products==actual_products);
    }



    @After
    public void afterTest(){
        driver.close();
    }
}
