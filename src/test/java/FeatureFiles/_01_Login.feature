#login kontrol senaryosu
#siteye git
#login bilgilerini gir
#giriş yaptığını doğrula





Feature: Login functionality

  @SmokeTest
  Scenario: Login with valid username and p assword


    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully