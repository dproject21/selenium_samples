package net.dproject21.sample.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private static final String BASE_URL = "http://www.yahoo.co.jp";

    protected final WebDriver driver;

    @FindBy(id = "srchtxt")
    @CacheLookup
    private WebElement wordBox;

    @FindBy(id = "srchbtn")
    @CacheLookup
    private WebElement searchButton;

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Using PageFactory
     * @return
     */
    public SearchPage initialize() {
        this.driver.get(BASE_URL);

        return PageFactory.initElements(this.driver, SearchPage.class);
    }

    /**
     * Set query
     * @param query
     */
    private void setSearchText(String query) {
        this.wordBox.clear();
        this.wordBox.sendKeys(query);;
    }

    /**
     * Search and Wait
     */
    public void waitForPageLoad(final String currentTitle) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return !currentTitle.equals(driver.getTitle());
            }
        };

        wait.until(condition);
    }

    /**
     * exec search
     * @param query
     */
    public ResultPage search(String query) {
        final String currentTitle = driver.getTitle();
        this.setSearchText(query);
        this.searchButton.submit();
        this.waitForPageLoad(currentTitle);

        return new ResultPage(this.driver).initialize();
    }


}
