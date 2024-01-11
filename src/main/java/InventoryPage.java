import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {
    private final WebDriver driver;
    By byProduct = By.className("inventory_item_name");

    public InventoryItemPage selectFirstItem(){
        WebElement firstItem = driver.findElement(byProduct);
        firstItem.click();
        return new InventoryItemPage(driver);
    }
    public InventoryItemPage selectItemByIndex(int index){
        WebElement inventoryItem = driver.findElement(By.cssSelector("div.inventory_item:nth-child("+index+")"));
        inventoryItem.click();
        return new InventoryItemPage(driver);
    }
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
}
