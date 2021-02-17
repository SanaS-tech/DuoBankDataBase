package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class KaterinaAPIStepDefs {

    static {
        RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com/api";
    }

    String token;
    Response response;
    RequestSpecification specification;


    @Given("I am logged on as a user and I have generated a token")
    public void iAmLoggedAnAsAUserAndIHaveGeneratedAToken() {


        Map responseMap = given().
                body("{\n" +
                        "    \"email\":\"bsmith@gmail.com\",\n" +
                        "    \"password\": \"bsmith123\"\n" +
                        "}").


                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().

                statusCode(equalTo(200)).
                extract().as(Map.class);

        token = (String)responseMap.get("token");



    }


    @When("I add the authorization token to the header")
    public void iAddTheAuthorizationTokenToTheHeader() {

        specification = given(). log().all().
                header("Authorization", token);
    }

    @When("Send a GET request to the endpoint {string}")
    public void sendAGETRequestToTheEndpoint(String endpoint) {




        response =   specification.when().log().all().
                get(endpoint);


    }

    @Then("The response code should be {int}")
    public void theResponseCodeShouldBeAndTheMortgageCountShouldBeCorrect(Integer int1) {
        response. then().log().all().
                assertThat().

                statusCode(equalTo(int1));
    }

    @When("I add the authorization token to the header and body with borrower id")
    public void iAddTheAuthorizationTokenToTheHeaderAndBodyWithBorrowerId() {
        specification = given(). log().all().
                header("Authorization", token).
                body("{\n" +
                        "\n" +
                        "\"id\": \"206\"\n" +
                        "\n" +
                        "}");

    }

    @When("Send a POST request to the endpoint {string}")
    public void sendAPOSTRequestToTheEndpoint(String endpoint) {

        response =   specification.when().log().all().
                post(endpoint);

    }

    @Then("The status code should be {int} and the body should contain borrower id {string}")
    public void theStatusCodeShouldBeAndTheBodyShouldContainBorrowerId(Integer status, String id) {

        response. then().log().all().
                assertThat().

                statusCode(equalTo(status)).
                body(containsString(id));

    }

    @When("I add first name, last name, email and password in the body to register the user")
    public void iAddFirstNameLastNameEmailAndPasswordInTheBodyToRegisterTheUser() {
        specification = given(). log().all().
                body("{\n" +
                        "    \"first_name\": \"Natalie\",\n" +
                        "    \"last_name\": \"Smith\",\n" +
                        "    \"email\" : \"nataliesmith@gmail.com\",\n" +
                        "    \"password\" : \"123456\"\n" +
                        "}");

    }

    @Then("The status code should be {int} and the body should contain message {string}")
    public void theStatusCodeShouldBeAndTheBodyShouldContainMessage(Integer status, String message) {
        response. then().log().all().
                assertThat().

                statusCode(equalTo(status)).
                body(containsString(message));

    }

    @When("I add first name, last name and email in the body to register the user")
    public void iAddFirstNameLastNameAndEmailInTheBodyToRegisterTheUser() {

        specification = given(). log().all().
                body("{\n" +
                        "    \"first_name\": \"Natalie\",\n" +
                        "    \"last_name\": \"Smith\",\n" +
                        "    \"email\" : \"nataliesmith@gmail.com\",\n" +
                        "   \n" +
                        "}");

    }

    @When("I Send a POST request to the endpoint {string} without providing email and password for login")
    public void iSendAPOSTRequestToTheEndpointWithoutProvidingEmailAndPasswordForLogin(String endpoint) {
        specification = given(). log().all().
                body("");
        response =   specification.when().log().all().
                post(endpoint);

    }

    @Then("The status code should be {int} and the body should contain cookie name {string}")
    public void theStatusCodeShouldBeAndTheBodyShouldContainCookieName(Integer status, String cookieName) {

        response. then().log().all().
                assertThat().

                statusCode(equalTo(status)).
                cookie(cookieName);

    }


}
