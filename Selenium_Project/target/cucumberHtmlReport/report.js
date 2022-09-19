$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/news.feature");
formatter.feature({
  "line": 1,
  "name": "Validating a news article is valid",
  "description": "",
  "id": "validating-a-news-article-is-valid",
  "keyword": "Feature"
});
formatter.before({
  "duration": 202666,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I navigate to \"https://www.theguardian.com/tone/news\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.theguardian.com/tone/news",
      "offset": 15
    }
  ],
  "location": "StepDefinitions.i_navigate_to(String)"
});
formatter.result({
  "duration": 4734645500,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Validate the first Guardian news article in Googles search results",
  "description": "",
  "id": "validating-a-news-article-is-valid;validate-the-first-guardian-news-article-in-googles-search-results",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I search the title of the first article in Google",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "more than 1 results should be found",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.searchTheTitleOfFirstNewsInGoogle()"
});
formatter.result({
  "duration": 1873281292,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 10
    }
  ],
  "location": "StepDefinitions.moreThanResultsShouldCanBeFound(int)"
});
formatter.result({
  "duration": 1195136417,
  "status": "passed"
});
formatter.after({
  "duration": 69417,
  "status": "passed"
});
});