package Elements;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    String SIGN_IN = "[class='authorization-link']";
    String USERNAME = "[name='login[username]']";
    String PASSWORD = "[name='login[password]']";
    String SUBMIT = "[name='send']";
    String WELCOME_MESSAGE = "[class='logged-in']";
    String MENU_SIGN_OUT = "[data-action='customer-menu-toggle']";
    String SIGN_OUT = "[href='http://168.119.186.3/customer/account/logout/']";
    String CONSUMER_CATEGORY = "//a[@class='level-top ui-corner-all']//span[text()='%s']";
    String PRODUCT_CATEGORY = "//li[@class='item']//a[text()='%s']";


    public WebElementFacade clickSignIn(){
        return $(By.cssSelector(SIGN_IN));
    }

    public WebElementFacade getUserName(){
        return $(By.cssSelector(USERNAME));
    }

    public WebElementFacade getPassword() {
        return $(By.cssSelector(PASSWORD));
    }

    public WebElementFacade getSubmitButton(){
        return $(By.cssSelector(SUBMIT));
    }

    public String getWelcomeMessage() {
        WebElementFacade elementFacade = $(By.cssSelector(WELCOME_MESSAGE));
        return elementFacade.getText();
    }
    public WebElementFacade getMenuButton(){
        return $(By.cssSelector(MENU_SIGN_OUT));
    }

    public WebElementFacade getSignOutButton(){
        return $(By.cssSelector(SIGN_OUT));
    }

    public WebElementFacade getCustomerCategoryButton(String category){
        String selector = String.format(CONSUMER_CATEGORY, category);
        return $(By.xpath(selector));
    }
    public WebElementFacade getProductCategoryButton(String product){
        String selector = String.format(PRODUCT_CATEGORY, product);
        return $(By.xpath(selector));
    }
}
