Feature: Login to Automation Practice site

  Scenario: Login to application using valid Username and Password
    Given Application is open in Chrome browser
    When User tries to login using valid "testuser51@test.com" and "password"
    Then Login to application should be successfull

    Scenario: Login to application using invalid username and password
    Given Application is open in Chrome browser
    When User tries to login using invalid "testuser50@test.com" and "password"
    Then Login to application should not be successfull
    
    