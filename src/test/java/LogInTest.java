import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class LogInTest {

    @Test
    public void successfulLogIn() {
        //Установка переменной среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        wait(5000, driver);
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=TEST&last_name=TEST&email=test%40test.com&password1=1234&password2=1234");
        String success = driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        Assert.assertEquals(success,
                "Account is created!",
                "Аккаунт не создан");
        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String pswd = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();

        driver.get("http://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pswd);
        driver.findElement(By.cssSelector("[value=Login]")).click();

//        logIn(driver);

        wait(100, driver);
        boolean loggedIn = driver.findElement(By.linkText("Logout")).isDisplayed();
        assertTrue(loggedIn,
                "Аккаунт не залогировался");
        driver.close();
    }

    public static void wait(int waitTime, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

}
