import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryItemPage {
    private final WebDriver driver;
    By byButtonAddToCart = By.cssSelector("[id*=add-to-cart]");
    By byCartLink = By.className("shopping_cart_link");
    By byReturnButton = By.id("back-to-products");

    public InventoryItemPage addToCart(){
        WebElement button = driver.findElement(byButtonAddToCart);
        button.click();
        return this;
    }
    public void moveToCart(){
        WebElement cart = driver.findElement(byCartLink);
        cart.click();
    }
    public InventoryPage returnToInventoryPage(){
        WebElement returnButton = driver.findElement(byReturnButton);
        returnButton.click();
        return new InventoryPage(driver);
    }
    public InventoryItemPage(WebDriver driver) {
        this.driver = driver;
    }
}
