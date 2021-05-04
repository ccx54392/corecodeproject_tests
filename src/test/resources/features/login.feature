Feature: test log in scenarios

  Background: go to the page
    Given that we try to log in at "login"

  Scenario Outline: enter user name and password
    When we add the user name as <username>
    And we add the password as <password>
    And we click on the login button
    Then the page should show the message <message>
    Examples:
      | username         | password    | message                        |
      | ""               | ""          | "User name can not be empty"   |
      | "adjfkdsjfksdjf" | ""          | "The user name does not exist" |
      | "user"           | "ajdfksljf" | "The password is incorrect"    |
      | "user"           | "user"      | "User logged in successfully"  |
