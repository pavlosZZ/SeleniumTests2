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
import Steps.ProductSteps;
import Steps.CartSteps;
import Steps.FilterSteps;

@RunWith(SerenityRunner.class)
public class FilterTests {

    public String username = "roni_cost@example.com";
    public String password = "roni_cost3@example.com";
    public String customerCategory = "Women";
    public String productCategory = "Tops";
    public String productName = "Atlas Fitness Tank";
    public String productPrice = "€18.00";
    public String productSize = "L";
    public String productColor = "Blue";


    @Managed
    WebDriver driver;
    String URL = "http://168.119.186.3/";

    @Steps
    LoginSteps loginSteps;
    @Steps
    ProductSteps productSteps;
    @Steps
    CartSteps cartSteps;
    @Steps
    FilterSteps filterSteps;

    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }


    @Test
    public void filterTest() throws InterruptedException {
        loginSteps.signIn();
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickSubmit();
        loginSteps.selectCustomerCategory(customerCategory);
        loginSteps.selectProductCategory(productCategory);
        filterSteps.selectFilter("Price");
        filterSteps.selectRange("30-40");
        boolean done = false;
        while(!done){
            filterSteps.checkPrices("30-40");
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
