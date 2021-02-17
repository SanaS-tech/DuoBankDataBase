Feature:  User details update
  @katerina @parallel
  Scenario: Update user income info in DB and verify the change on the UI

    When I update monthly bonuses with "1000", monthly dividends with "300" for a user with first name "Michael" and last name "Borrower"
    Then The same income info on the UI should be correct

  @katerina @parallel
  Scenario: Update user eConsent info in DB and verify the change on the UI

    When I update email with "michael.borrower@mb.com" for a user with first name "Michael" and last name "Borrower"
    Then The same eConsent info on the UI should be correct