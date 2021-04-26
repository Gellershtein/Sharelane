package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInCore {
    public static void logIn(WebDriver driver) {
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=2&zip_code=12345&first_name=TEST&last_name=TEST&email=test%40test.com&password1=1234&password2=1234");

        String email = driver.findElement(By.xpath("(//b)[2]")).getText();
        String pswd = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();

        driver.get("http://sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(pswd);
        driver.findElement(By.cssSelector("[value=Login]")).click();
    }
}
