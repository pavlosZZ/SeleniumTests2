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
import Steps.CartSteps;

@RunWith(SerenityRunner.class)
public class AddToCartTests {


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

    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }

    @Test
    public void addToCartVerification(){
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
        productSteps.goToCartPage();
        cartSteps.checkCartElements(productName);
        cartSteps.checkCartCounter();
    }

    @Test
    public void goToCartPageTest() throws InterruptedException {
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
        productSteps.goToCartPage();
        Thread.sleep(5000);
        cartSteps.checkCartElements(productName);
        cartSteps.checkCartCounter();
        cartSteps.goToFullCartPage();
        cartSteps.checkProductsIntoCart(productName);
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
