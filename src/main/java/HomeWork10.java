import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomeWork10 {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static NgWebDriver ngWebDriver;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");
    }
        @Test
        public void test01_findElement(){
           driver.findElement(By.id("btn")).click();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
           driver.findElement(By.id("message"));
        }
        @Test
        public void test02_findElement2() throws InterruptedException {
            driver.findElement(By.id("hidden")).click();
            Thread.sleep(5000);
            driver.findElement(By.id("finish1"));
            }

            @Test
            public void test03_waitElement3()  {
                driver.findElement(By.id("rendered")).click();
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
            }

            @Test
            public void test04_ngWebDriver()
            {
                driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
                ngWebDriver.waitForAngularRequestsToFinish();
                WebElement firstname = driver.findElement(ByAngular.model("firstName"));
                firstname.clear();
                firstname.sendKeys("Oriya");
                assertEquals(driver.findElement(By.xpath("//input")).getAttribute("value"),"Oriya");

            }
            @Test
        public void test05_testNg() throws InterruptedException {
        driver.navigate().to("https://dgotlieb.github.io/WebCalculator/");
                System.out.println(driver.findElement(By.id(Constants.SEVEN)).getSize());
                System.out.println(driver.findElement(By.id("six")).isDisplayed());
                WebCalculatePage.pressSix();
                WebCalculatePage.pressPlus();
                WebCalculatePage.pressEquals();
                WebCalculatePage.returnResults();
                Thread.sleep(1000);
                String expectedResult = "13";
                Assert.assertEquals(expectedResult, WebCalculatePage.returnResults());


            }
}






