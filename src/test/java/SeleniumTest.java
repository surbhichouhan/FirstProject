import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
    public static WebDriver driver;

    @BeforeTest
    void Setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");


    }

    @Test
    void testSteps() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id=\"menuToggle\"]//input")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[text() = \"Sign In Portal\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"usr\"]")).sendKeys("myName");
        driver.findElement(By.xpath("//input[@id=\"pwd\"]")).sendKeys("myName");
        driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();

        WebElement webElement = driver.findElement(By.xpath("//*[@id = 'ShoeType']"));
        String expectedCategory = "Formal Shoes";

        Assert.assertEquals(expectedCategory,webElement.getText());
        driver.close();
    }

}
