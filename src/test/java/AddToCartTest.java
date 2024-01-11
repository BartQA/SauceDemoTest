import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends BaseTest {
    @Test
    public void addProductToCart() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginAction = new LoginPage(driver);
        loginAction.login("standard_user","secret_sauce")
                .selectFirstItem()
                .addToCart()
                .returnToInventoryPage()
                .selectItemByIndex(2)
                .addToCart()
                .moveToCart();

        List<WebElement> allProducts = driver.findElements(By.className("cart_item"));

        Assert.assertEquals(allProducts.size(), 2, "Powinien być jeden product w koszyku a jest " + allProducts.size());

    }
}
