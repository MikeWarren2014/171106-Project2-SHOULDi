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
Feature: Registration
  Sanity testing user registration

  Scenario: Registering with SHOULDi
    Given I am at registration page
    When I input my firstName and lastName username and password and confirmPassword and gender and email and enter submit 
      | firstName | lastName | username  | password | confirmPassword | gender | email |
      | Mike | Warren | mwarren | p4ssw0rd | p4ssw0rd | male | mwarren@yahoo.coom |
      | Sue  | Rogers | srogers | srogers | srogers | female | srogers@gmail.com |
    Then I am at login page

