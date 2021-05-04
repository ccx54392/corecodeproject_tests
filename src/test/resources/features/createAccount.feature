Feature: Create new account

  Background: go to the page
    Given that we create a new account on "createAccount"

  Scenario Outline: Fill user name and password
    When we add the user name as <username>
    And we add the password as <password>
    And we click on the create account button
    Then the page should show the message <message>
    Examples:
      | username | password | message                                             |
      | ""       | ""       | "User name can not be empty"                        |
      | "qatest" | "qatest" | "User was successfully created, you can now log in" |