#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Error Validation
  I want to use this template for my feature file
  
  @Errorvalidation
  Scenario Outline: Validate the Errors with incorrect details
     Given I landed on Ecommerce page
    When I want to Login with Username <name> and Password <password>
    Then I verify "Incorrect email or password." message is displayed

    Examples: 
      | name             | password    | productName  |
      | kavyak@gmail.com |   Kavya@123 | ZARA COAT 3  |
