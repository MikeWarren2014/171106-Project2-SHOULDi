#Author: mwarren04011990@gmail.com
#Login feature file

Feature: Log into SHOULDi
  I wish to log into SHOULDi with proper credentials

  Scenario Outline: Logging into SHOULDi
    Given I am at login 
    When I login with "username" and "password"
    Then I arrive at dashboard
    Examples: 
      | username | password |
      |          |          |
