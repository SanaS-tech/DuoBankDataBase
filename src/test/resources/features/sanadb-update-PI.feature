Feature:  Admin updates Personal Info Tab in DB

  @sana @parallel
  Scenario: Update user marital status in DB and verify the change on the application
    When The admin updates the marital status to "Married" of a user with firstname "midland" and lastname "midlandLN"
    Then The admin views the appropriate application
    Then The admin sees the updated changes in the application


  @sana @parallel
  Scenario: Update user email in DB and verify the change on the application
    When The admin updates the email to "teambofflandUpdate@gmail.com" of a user with firstname "offland" and lastname "offlandLN"
    Then The admin sees the appropriate application
    Then The admin views the updated changes in the application