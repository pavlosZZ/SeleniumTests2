package Steps;

import Elements.CartPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;


import static org.junit.Assert.assertTrue;

public class CartSteps {

    public CartPage cartPage;

    @Step
    public void checkCartElements(String text){
        String element = cartPage.getCartElement(text).getText();
        assertTrue("There is no element with \"" + text + "\" name" , element.equals(text));
    }

    @Step
    public void checkCartCounter(){
        String actual_counter = cartPage.getCartCount().getText();
        String expected_counter = cartPage.getCartCounter().getText();
        System.out.println(actual_counter);
        System.out.println(expected_counter);
        assertTrue("The counter is not what's supposed to be.",actual_counter.equals(expected_counter));

    }

    @Step
    public void goToFullCartPage(){
        cartPage.getFullCart().click();
    }

    public void checkProductsIntoCart(String productName) {
        WebElementFacade product = cartPage.getFullCartsElement(productName);
        System.out.println(product.getText());
        assertTrue("The product you are searching for it doesn't exist.", product.isDisplayed());
    }
}
