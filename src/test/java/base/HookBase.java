package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HookBase {
    protected static WebDriver driver;
    protected static WebDriverWait wdWait;

    @Before

    public void init () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        /*@After
    public void TearDown() {
        driver.quit();
        driver.close();}
*/

    }
}
