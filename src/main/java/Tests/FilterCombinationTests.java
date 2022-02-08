package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;
import Steps.ProductSteps;
import Steps.CartSteps;
import Steps.FilterSimpleSteps;
import Steps.FilterCombinationSteps;

@RunWith(SerenityRunner.class)
public class FilterCombinationTests {

    public String username = "roni_cost@example.com";
    public String password = "roni_cost3@example.com";
    public String customerCategory = "Men";
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
        filterSteps.selectFilter("Category");
        filterCombinationSteps.getMenTank();
        Thread.sleep(5000);
        filterSteps.selectFilter("Price");
        filterCombinationSteps.selectRange("20-30");
        filterSteps.checkPrices("20-30");
        filterCombinationSteps.checkAllProducts();


    }


    @After
    public void afterTest(){
        driver.close();
    }
}
