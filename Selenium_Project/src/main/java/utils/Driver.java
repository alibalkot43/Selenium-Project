package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    public static long DEFAULT_WAIT = 20;
    protected static WebDriver driver;

    public static WebDriver getDefaultDriver() {
        if (driver != null) {
            return driver;
        }

        System.setProperty("webdriver.gecko.driver", "path/to/exe"); // add your path to the geckodriver.exe here
        DesiredCapabilities capabilities = null;
        capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability("takesScreenshot", true);
        driver = chooseDriver(capabilities);
        driver.manage().timeouts().setScriptTimeout(DEFAULT_WAIT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver chooseDriver(DesiredCapabilities capabilities) {
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("-headless", "-safe-mode");
        // capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return new FirefoxDriver(capabilities);
    }

    public static WebElement waitAndGetElementByCssSelector(WebDriver driver, String selector, int seconds) {
        By selection = By.cssSelector(selector);
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

    public static WebElement waitAndGetElementByXpathSelector(WebDriver driver, String selector, int seconds) {
        By selection = By.xpath(selector);
        return (new WebDriverWait(driver, seconds)).until(
                ExpectedConditions.visibilityOfElementLocated(selection));
    }

    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            } catch (NoSuchMethodError noSuchMethodError) { // in case quit fails
            } catch (NoSuchSessionException noSuchSessionException) { // in case close fails
            } catch (SessionNotCreatedException sessionNotCreatedException) { // in case close fails
            }
            driver = null;
        }
    }
}