package net.dproject21.sample.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

    protected final WebDriver driver;

    /**
     * construtor
     * @param driver
     */
    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Using PageFatory
     * @return
     */
    public ResultPage initialize() {
        return PageFactory.initElements(this.driver, ResultPage.class);

    }

    /**
     * get WebElement
     * @return
     */
    public List<WebElement> getResults(String url) {
        List<WebElement> results = driver.findElements(By.xpath("//a[@href='" + url + "']"));

        return results;
    }
}
