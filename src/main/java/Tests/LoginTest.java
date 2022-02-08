package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.LoginSteps;
import Steps.ProductSteps;

@RunWith(SerenityRunner.class)
public class LoginTest {


    public String username = "roni_cost@example.com";
    public String password = "roni_cost3@example.com";
    public String customerCategory = "Women";
    public String productCategory = "Bottoms";
    public String productName = "Ina Compression Short";
    public String productPrice = "€49.00";
    public String productSize = "28";
    public String productColor = "Blue";

    @Managed
    WebDriver driver;
    String URL = "http://168.119.186.3/";

    @Steps
    LoginSteps loginSteps;
    @Steps
    ProductSteps productSteps;

    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        loginSteps.signIn();
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickSubmit();
        Thread.sleep(2000);
        loginSteps.shouldBeLoggedIn();
    }

    @Test
    public void successfulLogout() throws InterruptedException {
        loginSteps.signIn();
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickSubmit();
        Thread.sleep(2000);
        loginSteps.shouldBeLoggedIn();
        loginSteps.clickMenuForSignOut();
        loginSteps.selectSignOut();
        loginSteps.shouldBeLoggedOut();
    }

    @Test
    public void productSelection() {
        loginSteps.signIn();
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickSubmit();
        loginSteps.selectCustomerCategory(customerCategory);
        loginSteps.selectProductCategory(productCategory);
        loginSteps.selectProduct(productName);
        productSteps.checkProductPrice(productPrice);
        productSteps.selectProductSize(productSize);
        productSteps.selectProductColor(productColor);
        productSteps.addProductToCart();

    }

    @After
    public void afterTest() {
        //Thread.sleep(5000);
        driver.close();
    }
}
