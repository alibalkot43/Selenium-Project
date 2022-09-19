Feature: Validating a news article is valid

Background: 
   Given I navigate to "https://www.theguardian.com/tone/news"

  Scenario: Validate the first Guardian news article in Googles search results
    When I search the title of the first article in Google
    Then more than 1 results should be found