# testing-exercise

Test automation suite which reads input from a file, and look for current issue (modern) UK licence plates in said file
The extra patterns can be defined

Extracts said licence plates from the file and acquires information about the vehicles from https://cartaxcheck.co.uk/

Compares the ddetails from the site against those stored in a different text file


Utilises Selenium-Selenide and Cucumber frameworks for automation
Produces a JSON report of the tests performed, as well as takes screenshots of the browser window if the test failed due to information being inaccessible from the website
