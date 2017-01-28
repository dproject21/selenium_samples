package net.dproject21.sample.selenium;

import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    @Test
    public void testSearchGoogle() throws Exception {
        for (WebDriverFactory factory : getDriverFactories()) {
            WebDriver driver = factory.create();

            try {
                SearchPage searchPage = new SearchPage(driver).initialize();
                ResultPage resultPage = searchPage.search("google");

                assertTrue(resultPage.getResults("https://www.google.co.jp/").size() > 0);

            } finally {
                driver.quit();
            }

        }

    }
}
