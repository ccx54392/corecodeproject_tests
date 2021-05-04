Feature: Create writer

  Background: go to the page
    Given that we create a writer on "createWriter"

  Scenario Outline: Fill writer name
    When we add the writer name as <name>
    And we click on the create writer button
    Then the page should show the message <message>
    Examples:
      | name   | message   |
      | "" | "Writer name can not be empty" |
      | "writer qa test" | "Writer was successfully created" |