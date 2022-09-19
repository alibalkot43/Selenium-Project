# Selenium-Project

TO RUN:
 - Firstly please add the path to the geckodriver executable in the "Driver.java" file (src > main > java > utils)
 - To run the test simply go to the "TestRunner.java" file (src > test > java/runners) and run the file (play button should be available in the file if using Visual Studio Code)
 - The tests by default are running with the browser being launched, but for quicker feedback they can be run in headless mode by uncommenting lines 38 & 39 in the "Driver.java" file (src > main > java > utils)
 - To view the result/report of the test run, simply launch the following file (which should open in your browser) --> target > cucumberHtmlReport > index.html

Improvements/Other Comments:
- With more time I would have added the ability to run cross-browser tests and support for other browsers
- I would have also added a few more features to test
- I would have also implemented functionality to make sure that the test is not verifying a news article in Google which comes from Guardian (as this is where we retrieved the article from in the fist place)
- Googles results are really dynamic and almost impossible to automate (hence the use of so many XPaths) so I would suggest against ever automating it :D
- If there was more functionality/tests I would have utilised the before and after functions more appropriately (src > main > java > steps > Hooks.java) for test setup and teardown
- Due to time restraints and a busy schedule I was unable to add more tests but I am more than happy to do so if the project I've created does not suffice.
