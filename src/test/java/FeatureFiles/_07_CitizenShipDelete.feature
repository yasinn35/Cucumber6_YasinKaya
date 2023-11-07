#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)
#oluşturulan her CitizenShip i siliniz.
#yukarıdaki senaryoyu farklı 5 değer için çalıştırınız
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

    When User delete the "<name>"
    Then Already exist message should be displayed


    Examples:
      | name      | shortname |
      | way678m21    | shbi6c3 |
      | wask345yf21  | shis466 |
      | was345kyg21  | shis465 |
      | was345kyf29  | shgs464 |
      | wasky235h28  | shds463 |