Feature:  e2e testing

@api
  Scenario: Verify the inland application is saved

    Given Login as user and generate token
    When Add authorization token and add application id
    Then Send POST request to the endpoint "/mortagagedetails.php"
    Then The status code is confirmed and the body contains application id "202"


  @api
  Scenario: Verify user expense is registered as Rental Payment
    Given Login as user and generate token
    When Add authorization token
    Then Send POST request to an endpoint "/mortagagedetails.php"
    Then The application should contain expenses as "1500"
