import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static core.LogInCore.logIn;
import static core.ShoppingCartCore.*;

public class SoppingCartTest {

    @Test
    public void discountShouldBeZeroForBooksUpTo19quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //19 books
        changeBooksQuantity(driver, "19");
        checkDiscountPercent(driver, "0");
        checkDiscountAmount(driver, "0.0");
        checkTotalAmount(driver, "190.00");

        driver.quit();
    }

    @Test
    public void discountShouldBe2ForBooksBetween20and49quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //20 books
        changeBooksQuantity(driver, "20");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(20);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //49 books
        changeBooksQuantity(driver, "49");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(49);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }

    @Test
    public void discountShouldBe3ForBooksBetween50and99quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //50 books
        changeBooksQuantity(driver, "50");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(50);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //99 books
        changeBooksQuantity(driver, "99");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(99);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }

    @Test
    public void discountShouldBe4ForBooksBetween100and499quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //100 books
        changeBooksQuantity(driver, "100");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(100);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //499 books
        changeBooksQuantity(driver, "499");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(499);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }

    @Test
    public void discountShouldBe5ForBooksBetween500and999quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //500 books
        changeBooksQuantity(driver, "500");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(500);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //999 books
        changeBooksQuantity(driver, "999");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(999);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }

    @Test
    public void discountShouldBe6ForBooksBetween1000and4999quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //1000 books
        changeBooksQuantity(driver, "1000");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(1000);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //4999 books
        changeBooksQuantity(driver, "4999");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(4999);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }

    @Test
    public void discountShouldBe7ForBooksBetween5000and9999quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //5000 books
        changeBooksQuantity(driver, "5000");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(5000);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //9999 books
        changeBooksQuantity(driver, "9999");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(9999);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }

    @Test
    public void discountShouldBe8ForBooksMoreThan10000quantity() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        logIn(driver);
        addBookToCart(driver);

        //10000 books
        changeBooksQuantity(driver, "10000");
        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(10000);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));

        //1000000 books
        changeBooksQuantity(driver, "1000000");
        percentDiscountAmountDiscountTotalAmountDiscount = calculationDiscount(1000000);
        checkDiscountPercent(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(0));
        checkDiscountAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(1));
        checkTotalAmount(driver, percentDiscountAmountDiscountTotalAmountDiscount.get(2));
        driver.quit();
    }
}
