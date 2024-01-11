import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;
    By byUserName = By.id("user-name");
    By byPassword = By.id("password");
    By bySubmitButton = By.id("login-button");

    public InventoryPage login(String username, String password){
        WebElement user = driver.findElement(byUserName);
        user.sendKeys(username);
        WebElement pass = driver.findElement(byPassword);
        pass.sendKeys(password);
        WebElement login = driver.findElement(bySubmitButton);
        login.click();
        return new InventoryPage(driver);
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
}
