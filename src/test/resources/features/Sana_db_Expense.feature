Feature:  Verify Expenses in the database

  Scenario: Verify Borrower's personal info is correctly mapped with the DB
    Given The user logs into the account
    When The user clicks on the Application List and views their application
    Then The user is able to verify their personal info
    And The user details should be correctly mapped in the mortgage table of database



  @sana @expense @parallel
    #User is not able to verify their expense
  Scenario: Verify Borrower's expenses is correctly mapped with the DB
    Given The User logs into the account
    When The User clicks on the Application List and views their application
    Then The user is able to verify their expense
    And The user expense amount should be correctly mapped in the mortgage table of database