@regression
Feature: user should be able to login to the system

Background: user open browser and go to login page

    And user navigates to login page

  #test scenario
    Scenario: user login valid username and password

    When USER ENTER "tomsmith" and "SuperSecretPassword!"
    And USER CLICK ON LOGIN BUTTON
    Then  USER COULD LOGIN SUCCESSFULLY
    And AND GO TO HOME PAGE

    Scenario: user login valid username and password

        And user navigates to login page
        When USER ENTER "mohamed" and "Super"
        And USER CLICK ON LOGIN BUTTON
        Then  USER COULD not LOGIN SUCCESSFULLY




