package Steps;

import Elements.ProductPage;
import net.thucydides.core.annotations.Step;

import static org.junit.Assert.assertTrue;

public class ProductSteps {

    public ProductPage productPage;

    @Step
    public void checkProductPrice(String expected_price){
        String price = productPage.getProductsPrice().getText();
        assertTrue("The actual price is not equal with the expected one.",price.equals(expected_price));
    }

    @Step
    public void selectProductSize(String price){
        productPage.getProductSize(price).click();
    }

    @Step
    public void selectProductColor(String color){
        productPage.getProductColor(color).click();
    }

    @Step
    public void addProductToCart(){
        productPage.addProductToCart().click();
    }

    public void goToCartPage() {
        productPage.getCartButton().click();
    }
}
