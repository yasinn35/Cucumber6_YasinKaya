Feature: Contry Multi Scenario

  Background: #before senaryo
  Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country

    @Regression
    Scenario: Create country
      When Create a country
      Then Success message should be displayed


      @Regression
      Scenario: Create country 2
        When Create a country name as "yas3h55"  code as "hgU5"
        Then Success message should be displayed