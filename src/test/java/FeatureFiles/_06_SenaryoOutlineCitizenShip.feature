



Feature: Citizenship Functionality



  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship


  Scenario Outline: Create a Citizenship
    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Success message should be displayed

    When Create a Citizenship name as "<name>" short name as "<shortname>"
    Then Already exist message should be displayed
    Examples:
      | name     | shortname|
      | yaskyg22 |shis563|
      | yaskyg24 |shis566|
      | yaskyg25 |shis565|
      | yaskyg26 |shis564|
      | yaskyg27 |shis563|