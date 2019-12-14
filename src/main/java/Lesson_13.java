import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Lesson_13 {
    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "F:\\34\\Fox\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.gecko.driver", "D:\\34\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://automationpractice.com/");
//        System.setProperty("webdriver.chrome.driver","F:\\34\\Chrom\\1\\chromedriver.exe");
//                WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement search = driver.findElement(By.id("search_query_top"));
        search.sendKeys("Blouse");
        WebElement searchButton = driver.findElement(By.name("submit_search"));
        searchButton.click();
        driver.manage().window().maximize();
//        js.executeScript("window.scrollBy(0,1000)");
        WebElement list = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("list")));
        list.click();
        js.executeScript("window.scrollBy(0,1000)");
        WebElement buttonAdd = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div/div[3]/div/div[2]/a[1]/span")));
        buttonAdd.click();

//        WebElement continueShopping = driver.findElement(By.cssSelector("html body#search.search.hide-right-column.lang_en div#page div.header-container header#header div div.container div.row div#layer_cart div.clearfix div.layer_cart_product.col-xs-12.col-md-6 span.cross"));
//        continueShopping.click();
//        WebElement cart = driver.findElement(By.cssSelector(".shopping_cart > a:nth-child(1)"));
//        cart.click();

    }
}
