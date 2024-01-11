import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTest {

    protected static WebDriver driver;

    public static final Logger log = LogManager.getLogger(BaseTest.class);
    public long startTime;

    @BeforeClass
    public void setUpBeforeClass() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void beforeMethod(ITestResult myTest){
        log.info("Test "+myTest.getMethod().getMethodName()+" started");
        startTime = System.currentTimeMillis();
    }

    @AfterMethod
    public void methodTearDown(ITestResult result) throws IOException {
        if(result.getStatus() != ITestResult.SUCCESS){
            String screenshotName = "screenshots/" + result.getName() + result.getEndMillis() + ".png";
            ScreenshotUtil.takeScreenshot(driver, screenshotName);
        }
        long endTime = System.currentTimeMillis();
        log.info("Test zajął {}ms",endTime-startTime);
    }

    @AfterClass
    public void classTearDown() {
        driver.quit();
    }
}
