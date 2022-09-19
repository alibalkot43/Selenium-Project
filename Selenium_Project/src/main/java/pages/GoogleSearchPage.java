package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.Driver;

import java.util.List;

public class GoogleSearchPage {
    public WebDriver driver;
    public String googleURL = "https://www.google.com/";

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getSearchBox() {
        return driver.findElement(By.name("q"));
    }

    private WebElement getCookiesButton() {
        return driver.findElement(By.cssSelector("#L2AGLb > div:nth-child(1)"));
    }

    private List<WebElement> getAllSearchResults() {
        String xpathForSearchResults = "//a/h3";
        return driver.findElements(By.xpath(xpathForSearchResults));
    }

    private void waitForSearchResults() {
        String xpathSearchResults = "//div[@id='search']";
        Driver.waitAndGetElementByXpathSelector(driver, xpathSearchResults, 30);
    }

    public void acceptCookies() {
        WebElement acceptCookiesButton = getCookiesButton();
        acceptCookiesButton.click();
    }

    public void navigateToGoogle() {
        driver.get(googleURL);
    }

    public void searchGoogle(String newsArticle) {
        WebElement searchBox = getSearchBox();
        searchBox.clear();
        searchBox.sendKeys(newsArticle);
        searchBox.sendKeys(Keys.ENTER);
    }

    public int getCountOfMatchedRecords(String newsArticle) {
        waitForSearchResults();
        int count = 0;
        for (WebElement element : getAllSearchResults()) {
            String linkText = element.getText();
            if (linkText.endsWith(" ...")) {
                linkText = linkText.substring(0, linkText.length() - 4);
            }

            if (linkText.startsWith("(")) {
                linkText = linkText.substring(4);
            }

            System.out.println("Google Search Result: " + linkText);
            System.out.println("First News Article on Guardian: " + newsArticle);

            if (newsArticle.contains(linkText.trim())) {
                count += 1;
            }
        }

        return count;
    }
}