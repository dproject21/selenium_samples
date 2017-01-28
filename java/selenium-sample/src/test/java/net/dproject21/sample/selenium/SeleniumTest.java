package net.dproject21.sample.selenium;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class SeleniumTest extends TestCase
{
    public interface WebDriverFactory {

        public WebDriver create();

    }

    public static Iterable<WebDriverFactory> getDriverFactories() {
        ArrayList<WebDriverFactory> factories = new ArrayList<WebDriverFactory>();
        factories.add(new WebDriverFactory() {
            @Override
            public WebDriver create() {
                return new ChromeDriver();
            }
        });
        return factories;
    }

    private static final String url = "http://yahoo.co.jp";

    @Test
    public void testSearchGoogle() throws Exception {
        for (WebDriverFactory factory : getDriverFactories()) {
            WebDriver driver = factory.create();

            try {
                driver.get(url);
                Wait<WebDriver> wait = new WebDriverWait(driver, 10);

                WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id("srchbtn")));

                //TopPage
                driver.findElement(By.id("srchtxt")).sendKeys("google");
                button.submit();

                //ResultPage
                List<WebElement> elements = driver.findElements(By.xpath("//a[@href='https://www.google.co.jp/']"));

                assertTrue(elements.size() > 0);

            } finally {
                driver.quit();
            }

        }

    }
}
