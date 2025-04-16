
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Order a Product
    Given I want to Login with Username <name> and Password <password>
    When I add product <productName> to cart
    And I Checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on Confirmation page

    Examples: 
      | name             | password    | productName  |
      | kavyak@gmail.com |   Kavya@124 | ZARA COAT 3  |
     
