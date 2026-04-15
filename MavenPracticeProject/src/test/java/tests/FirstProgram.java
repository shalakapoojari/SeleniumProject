package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class FirstProgram {

    WebDriver driver;

    @Test
    public void openMyBlog() throws Exception {
        driver.get("https://www.softwaretestingmaterial.com/");
        Thread.sleep(3000); // reduced wait
    }

    @BeforeClass
    public void beforeClass() {

        // ✅ Automatically download correct ChromeDriver
        WebDriverManager.chromedriver().setup();

        // ✅ Headless mode (REQUIRED for Jenkins)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // ✅ Launch browser
        driver = new ChromeDriver(options);

        // ✅ Modern timeout (Selenium 4)
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}