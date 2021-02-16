Feature: Verify data mapping of the user details in the database

  Background:
    Given I am on the home page
    When I enter "bsmith@gmail.com" for email address and "bsmith123" for password and click on login
    And I click on Application List and click on View Details for borrower "2"
    Then I should land on the Mortgage Application page

  @katerina
  Scenario: Verify income info is correctly mapped with the DB

    And The income info should be correctly mapped in the users table of database for "Michael" "Borrower"

  @katerina
  Scenario: Verify econsent info is correctly mapped with the DB

    And The econsent info should be correctly mapped in the users table of database for "Michael" "Borrower"