#Author: Razvan Prepelita
#Feature: Request Demo Functionality
#Scenario:Test error messages when adding data in the Request Demo Form
Feature: Request A Demo Form
  Description: The purpose of this feature is to test the Request Demo form

  Background: Aodocs Home Page is opened
    Given I search 'Aodocs' on Google
    And I press on the Aodocs link
    Then Aodocs Home Page is opened

  Scenario Outline: Request_Demo_As_Not_Login_User
    When I click button Request a Demo
    And the Contact Form is opened
    And I fill First Name with "<firstName>"
    And I fill Last Name with "<lastName>"
    And I fill Email with "<email>"
    And I fill Company Name with "<companyName>"
    And I select "<companySize>" from Company Size
    Then "<errorMessageLastName>" should appear under LastName
    And "<errorMessageFirstName>" should appear under CompanyName
    And "<errorMessageMail>" should appear under Mail
    And "<errorMessageCompanyName>" should appear under CompanyName

    Examples: 
      | firstName | lastName | email    | companyName | companySize      | errorMessageFirstName                | errorMessageLastName                 | errorMessageMail                   | errorMessageCompanyName              |
      | Lucas     |          | dwdwdwed |             | 0-4 employees    |                                      | Please complete this required field. | Email must be formatted correctly. | Please complete this required field. |
      |           |          | dgfgdfgd |             | 51-350 employees | Please complete this required field. | Please complete this required field. | Email must be formatted correctly. | Please complete this required field. |
