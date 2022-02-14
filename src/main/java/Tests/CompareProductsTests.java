package Tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import Steps.*;

import java.util.ArrayList;
import java.util.List;

@RunWith (SerenityRunner.class)
public class CompareProductsTests {

    public String username = "roni_cost@example.com";
    public String password = "roni_cost3@example.com";
    public String customerCategory = "Men";
    public String productCategory = "Tops";
    public String productName = "Tiberius Gym Tank";
    public String productName2 = "Sparta Gym Tank";
    public String productPrice = "€28.00";
    public String productSize = "28";
    public String productColor = "Purple";

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
    CompareProductsSteps compareProductsSteps;

    @Before
    public void beforeTest()  {
        driver.navigate().to(URL);
        driver.manage().window().maximize();
        //Thread.sleep(5000);
    }

    @Test
    public void compareProductsTest(){
        loginSteps.signIn();
        loginSteps.enterUsername(username);
        loginSteps.enterPassword(password);
        loginSteps.clickSubmit();
        loginSteps.selectCustomerCategory(customerCategory);
        loginSteps.selectProductCategory(productCategory);
        loginSteps.selectProduct(productName);
        compareProductsSteps.addToCompare();
        loginSteps.selectCustomerCategory(customerCategory);
        loginSteps.selectProductCategory(productCategory);
        loginSteps.selectProduct(productName2);
        compareProductsSteps.addToCompare();
        compareProductsSteps.goToComparePage();
        List<String> productsToCompare = new ArrayList<> ();
        productsToCompare.add (productName);
        productsToCompare.add (productName2);
        compareProductsSteps.checkProductsIntoCompareList (productsToCompare);
    }


    @After
    public void afterTest(){
        driver.close();
    }
}
