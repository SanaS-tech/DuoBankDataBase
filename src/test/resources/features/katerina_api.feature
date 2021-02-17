Feature:  End to end testing
  @api
  Scenario: Verify getmortgage endpoint

    Given I am logged on as a user and I have generated a token
    When I add the authorization token to the header
    And Send a GET request to the endpoint "/getmortagage.php"
    Then The response code should be 200

  @api
  Scenario: Verify the borrower

    Given I am logged on as a user and I have generated a token
    When I add the authorization token to the header and body with borrower id
    And Send a POST request to the endpoint "/mortagagedetails.php"
    Then The status code should be 200 and the body should contain borrower id "206"
  @api
  Scenario: Verify the registered user

    When I add first name, last name, email and password in the body to register the user
    And Send a POST request to the endpoint "/register.php"
    Then The status code should be 200 and the body should contain message "This E-mail already in use!"
  @api
  Scenario: Verify if user can be registered without password

    When I add first name, last name and email in the body to register the user
    And Send a POST request to the endpoint "/register.php"
    Then The status code should be 200 and the body should contain message "Please Fill in all Required Fields!"
  @api
  Scenario: Verify login without email and password

    When I Send a POST request to the endpoint "/login.php" without providing email and password for login
    Then The status code should be 200 and the body should contain message "Please Fill in all Required Fields!"
  @api
  Scenario: Verify the cookie

    Given I am logged on as a user and I have generated a token
    When I add the authorization token to the header and body with borrower id
    And Send a POST request to the endpoint "/mortagagedetails.php"
    Then The status code should be 200 and the body should contain cookie name "PHPSESSID"

