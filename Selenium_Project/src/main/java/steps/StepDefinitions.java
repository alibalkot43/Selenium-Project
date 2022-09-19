package steps;

import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import utils.Driver;
import pages.GuardianNewsPage;
import pages.GoogleSearchPage;

public class StepDefinitions {
    protected WebDriver driver = Driver.getDefaultDriver();
    protected String firstNewsTitle = "";

    protected GuardianNewsPage guardianNewsPage = new GuardianNewsPage(driver);
    protected GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);

    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String link) {
        driver.get(link);
    }

    @When("^I search the title of the first article in Google$")
    public void searchTheTitleOfFirstNewsInGoogle() {
        firstNewsTitle = guardianNewsPage.getFirstNewsTitle();
        googleSearchPage.navigateToGoogle();
        googleSearchPage.acceptCookies();
        googleSearchPage.searchGoogle(firstNewsTitle);
    }

    @Then("^more than (\\d+) results should be found$")
    public void moreThanResultsShouldCanBeFound(int expectedCount) {
        int actualCount = googleSearchPage.getCountOfMatchedRecords(firstNewsTitle);
        System.out.println("Actual count is: " + actualCount);
        Assert.assertTrue(actualCount >= expectedCount);
    }
}