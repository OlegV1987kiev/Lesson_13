package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ShopTest {
    static String totalProducts = "$54.00";

    static String totalShipping = "$2.00";
    static String total = "$56.00";
    static String tax = "$0.00";
    static String uperTotal = "$56.00";
    static  String message ="(empty)";

    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.gecko.driver", "D:\\34\\geckodriver-v0.26.0-win64\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://automationpractice.com/");
        System.setProperty("webdriver.chrome.driver", "D:\\34\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        WebElement buttonAdd = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div/div[3]/div/div[2]/a[1]")));
        buttonAdd.click();
        Thread.sleep(1000);
////        driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Blouse&submit_search=");
        driver.navigate().refresh();
        WebElement clickToCart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[2]")));
        clickToCart.click();
        WebElement addPluse = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("cart_quantity_up_2_7_0_0")));
        addPluse.click();
        js.executeScript("window.scrollBy(0,300)");
//        Thread.sleep(2000);
        driver.navigate().refresh();

        WebElement validationTotalProducts = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("total_product_price_2_7_0")));
        String b = validationTotalProducts.getText();
        System.out.println(totalProducts.equals(b));
        System.out.println(b);
        WebElement validationTotalShipping = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("total_shipping")));
        String c = validationTotalShipping.getText();
        System.out.println(totalShipping.equals(c));
        System.out.println(c);
        WebElement validationTotal = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("total_price_without_tax")));
        String a = validationTotal.getText();
        System.out.println(total.equals(a));
        System.out.println(a);
        WebElement validationTax = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("total_tax")));
        String d = validationTax.getText();
        System.out.println(tax.equals(d));
        System.out.println(d);
        WebElement validationUperTotal = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("total_price_container")));
        String e = validationUperTotal.getText();
        System.out.println(uperTotal.equals(e));
        System.out.println(e);
        WebElement deleteProduct = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("2_7_0_0")));
        deleteProduct.click();
        driver.navigate().refresh();
//        clickToCart.click();
        WebElement checkMessage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("center_column")));
        WebElement checkEntry = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[5]")));
        System.out.println("Is  basket empty? "+message.equals(checkEntry.getText()));

        System.out.print(checkMessage.getText());
    }

}

