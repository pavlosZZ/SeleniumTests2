package Steps;

import Elements.LoginPage;
import Elements.ProductPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    public LoginPage loginPage;
    public ProductPage productPage;

    @Step
    public void enterUsername(String username){
        loginPage.getUserName().sendKeys(username);
    }

    @Step
    public void enterPassword(String password) {
        loginPage.getPassword().sendKeys(password);
    }

    @Step
    public void signIn() {
        loginPage.clickSignIn().click();
    }

    @Step
    public void clickSubmit() {
        loginPage.getSubmitButton().click();
    }

    @Step
    public void shouldBeLoggedIn() {
        String EXPECTED_MESSAGE = "Welcome, Veronica Costello!";
        String CURRENT_MESSAGE = loginPage.getWelcomeMessage();
        assertTrue("Login failed.", EXPECTED_MESSAGE.equals(CURRENT_MESSAGE));
    }

    @Step
    public void clickMenuForSignOut() {
        loginPage.getMenuButton().click();
    }

    @Step
    public void selectSignOut() {
        loginPage.getSignOutButton().click();
    }

    @Step
    public void shouldBeLoggedOut() {
        String EXPECTED_URL = "http://168.119.186.3/customer/account/logoutSuccess/";
        String CURRENT_URL = loginPage.getDriver().getCurrentUrl();
        assertTrue("Logout failed.", EXPECTED_URL.equals(CURRENT_URL));
    }


    public void selectCustomerCategory(String category) {
        loginPage.getCustomerCategoryButton(category).click();
    }

    public void selectProductCategory(String product) {
        loginPage.getProductCategoryButton(product).click();
    }


    public void selectProduct(String product) {
        List<WebElementFacade> elements = productPage.getProductByImage(product);
        for(WebElementFacade element : elements){
            String productText = element.getText ();
            if(productText.contains (product)){
                element.click ();
                break;
            }
        }
    }
}
