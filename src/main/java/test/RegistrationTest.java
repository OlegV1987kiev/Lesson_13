package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTest {

    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "F:\\34\\Fox\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
        String emailReg = "olehv111@gmail.com";
        System.setProperty("webdriver.gecko.driver", "D:\\34\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://automationpractice.com/");
//        System.setProperty("webdriver.chrome.driver","F:\\34\\Chrom\\1\\chromedriver.exe");
//                WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement singIn = driver.findElement(By.cssSelector(".login"));
        singIn.click();
        WebElement email = driver.findElement(By.id("email_create"));
        email.sendKeys(emailReg);
        WebElement createAccount = driver.findElement(By.cssSelector("#SubmitCreate > span:nth-child(1)"));
        createAccount.click();


        WebElement titleMr = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));

        titleMr.click();
        WebElement customerFirstName = driver.findElement(By.id("customer_firstname"));
        customerFirstName.sendKeys("Oleh");
        WebElement customerLastName = driver.findElement(By.id("customer_lastname"));
        customerLastName.sendKeys("Test");
        WebElement Password = driver.findElement(By.id("passwd"));
        Password.sendKeys("123456A");
        WebElement firstName = driver.findElement(By.id("firstname"));
        firstName.sendKeys("Oleh");
        WebElement lastName = driver.findElement(By.id("lastname"));
        lastName.sendKeys("Test");
        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("address1");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Kiev");

        WebElement phoneMobile = driver.findElement(By.id("phone_mobile"));
        phoneMobile.sendKeys("+3800014414");
        WebElement register = driver.findElement(By.cssSelector("#submitAccount > span:nth-child(1) > i:nth-child(1)"));
        register.click();

//        WebElement dynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("dynami cElement_id")));
        WebElement validationMessage = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert")));
//        boolean b = validationMessage.isEnabled();

        boolean b;
        if (b = validationMessage.isEnabled()) {
            String a = validationMessage.getText();
            System.out.println("The validation message contains the text: "+b);
            System.out.println("validation message text: "+a);
        } else {


            System.out.println("There are not  errors");
        }
    }

}



