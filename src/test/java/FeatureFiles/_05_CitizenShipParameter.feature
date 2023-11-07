#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini parameter yöntemi ile doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız. (negatif test)

  Feature: Citizenship Functionality



    Background:
      Given Navigate to Campus
      When Enter username and password and click login button
      Then User should login successfully
      And Navigate to Citizenship


      Scenario: Create a Citizenship
        When Create a Citizenship name as "yaskyg23" short name as "shis567"
        Then Success message should be displayed
        
        When Create a Citizenship name as "yaskyg23" short name as "shis567"
        Then Already exist message should be displayed