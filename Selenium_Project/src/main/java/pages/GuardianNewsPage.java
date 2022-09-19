package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class GuardianNewsPage {
    public WebDriver driver;

    public GuardianNewsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getFirstNewsElement() {
        String firstNewsArticleXPath = "//a[@data-link-name='article'][1]";
        Driver.waitAndGetElementByXpathSelector(driver, firstNewsArticleXPath, 30);
        return driver.findElement(By.xpath(firstNewsArticleXPath));
    }

    public String getFirstNewsTitle() {
        WebElement firstNewsElement = getFirstNewsElement();
        String newsTitle = firstNewsElement.getText().trim();
        if (newsTitle.endsWith(" – live")) {
            newsTitle = newsTitle.substring(0, newsTitle.length() - 7);
        }
        if (newsTitle.startsWith("Live ")) {
            newsTitle = newsTitle.substring(4);
        }
        return newsTitle.trim().replaceAll("’", "'");
    }
}