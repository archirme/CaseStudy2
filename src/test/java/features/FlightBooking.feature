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
Feature: Flight Booking functionality of ibibo website

  Scenario: Book one way flight for the user from Ahemdabad to Chennai
    Given User launches website successfully for one way trip
    When All the information entered by the User for one-way flight are proper
    Then User able to click on Search and get the list of flights available
    
   Scenario Outline: Book one way flight for the user from Ahemdabad to Chennai
    Given User launches website successfully for one way trip
    When User provides details for "<tripType>" flight with "<startDate>" and "<returnDate>" from "<sourceCity>" to "<destinationCity>" with class as "<classType>" for "<noOfAdults>","<noOfChildren>","<noOfInfants>"  
    Then User able to click on Search and get the list of flights available
  
  Examples:
  |tripType|startDate|returnDate|sourceCity|destinationCity|classType|noOfAdults|noOfChildren|noOfInfants|
	|Round-trip|04-08-2022|25-08-2022|Ahmedabad|Chennai      |Economy  |1         | 0          |0          |
	|Round-trip|29-08-2022|23-09-2022|Coimbatore|Chennai     |Business |2         |1           |1          |
	|Round-trip|06-08-2022|02-09-2022|Coimbatore|Chennai     |Business |2         |1           |1          |
   