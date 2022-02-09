package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;
import Steps.FilterSimpleSteps;

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

    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }

    public void deleteFilterTest() {
        loginSteps.signIn ();
        loginSteps.enterUsername (username);
        loginSteps.enterPassword (password);
        loginSteps.clickSubmit ();
        loginSteps.selectCustomerCategory (customerCategory);
        loginSteps.selectProductCategory (productCategory);
        filterSteps.selectFilter(filter);
        filterSteps.selectRange(range);
    }



    @After
    public void afterTest(){
        driver.close();
    }
}
