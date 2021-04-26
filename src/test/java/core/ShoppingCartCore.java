package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ShoppingCartCore {

    public static void addBookToCart(WebDriver driver) {
        driver.findElement(By.xpath("//a[contains(@href, 'show_book')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'add_to_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@href, 'shopping_cart')]")).click();
    }

    public static void changeBooksQuantity(WebDriver driver, CharSequence quantity) {
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys(quantity);
        driver.findElement(By.cssSelector("[value=Update]")).click();
    }

    public static void checkDiscountPercent(WebDriver driver, CharSequence percentShouldBe) {
        String discountPercent = driver.findElement(By.xpath("((//tr)[9]//td)[5]")).getText();
        assertEquals(discountPercent, percentShouldBe, "Incorrect discount,% value");

    }

    public static void checkDiscountAmount(WebDriver driver, CharSequence amountShouldBe) {
        String discountAmount = driver.findElement(By.xpath("((//tr)[9]//td)[6]")).getText();
        assertEquals(discountAmount, amountShouldBe, "Incorrect discount,$ value");

    }

    public static void checkTotalAmount(WebDriver driver, CharSequence totalAmountShouldBe) {
        String discountPercent = driver.findElement(By.xpath("((//tr)[9]//td)[7]")).getText();
        assertEquals(discountPercent, totalAmountShouldBe, "Incorrect total,$ value");

    }

    public static ArrayList<CharSequence> calculationDiscount(int bookQuantity) {

        ArrayList<CharSequence> percentDiscountAmountDiscountTotalAmountDiscount = new ArrayList<>();
        int percentDiscount;
        double amountDiscount, totalAmountDiscount;

        if (bookQuantity < 20) {
            percentDiscount = 0;
        } else if (bookQuantity <= 49) {//        #20 - 49    | 2
            percentDiscount = 2;
        } else if (bookQuantity <= 99) { //        #50 - 99    | 3
            percentDiscount = 3;
        } else if (bookQuantity <= 499) { //        #100-499    | 4
            percentDiscount = 4;
        } else if (bookQuantity <= 999) { //        #500-999    | 5
            percentDiscount = 5;
        } else if (bookQuantity <= 5999) { //        #1000-4999  | 6
            percentDiscount = 6;
        } else if (bookQuantity <= 9999) { //        #5000-9999  | 7
            percentDiscount = 7;
        } else { //        #10000 and more | 8
            percentDiscount = 8;
        }

        amountDiscount = 10 * bookQuantity * ((double) percentDiscount / 100);
        totalAmountDiscount = 10 * bookQuantity - amountDiscount;
        percentDiscountAmountDiscountTotalAmountDiscount.add(String.valueOf(percentDiscount));
        percentDiscountAmountDiscountTotalAmountDiscount.add(String.valueOf(amountDiscount));
        percentDiscountAmountDiscountTotalAmountDiscount.add(String.valueOf(totalAmountDiscount));
        return percentDiscountAmountDiscountTotalAmountDiscount;
    }
}
