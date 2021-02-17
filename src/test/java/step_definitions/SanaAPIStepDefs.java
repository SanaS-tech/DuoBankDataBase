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

public class SanaAPIStepDefs {

    static {
        RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com/api";
    }

    String token;
    Response response;
    RequestSpecification specs;



    @Given("Login as user and generate token")
    public void LoginAsUserAndGenerateToken() {


        Map responseMap = given().
                body("{\n" +
                        "    \"email\":\"teambinland@gmail.com\",\n" +
                        "    \"password\": \"codelab99\"\n" +
                        "}").


                when().log().all().
                post("/login.php").
                then().log().all().
                assertThat().

                statusCode(equalTo(200)).
                extract().as(Map.class);

        token = (String)responseMap.get("token");



    }


    @When("Add authorization token and add application id")
    public void AddAuthorizationTokenAndAddApplicationId() {
        specs = given(). log().all().
                header("Authorization", token).
                body("{\n" +
                        "\n" +
                        "\"id\": \"202\"\n" +
                        "\n" +
                        "}");

    }

    @Then("Send POST request to the endpoint {string}")
    public void sendPOSTRequestToTheEndpoint(String endpoint) {

        response =   specs.when().log().all().
                post(endpoint);

    }

    @Then("The status code is confirmed and the body contains application id {string}")
    public void theStatusCodeIsConfirmedAndTheBodyContainsApplicationId( String id) {

        response. then().log().all().
                assertThat().

                statusCode(equalTo(200)).
                body(containsString(id));

    }



    @When("Add authorization token")
    public void AddAuthorizationToken() {
        specs = given(). log().all().
                header("Authorization", token).
                body("{\n" +
                        "\n" +
                        "\"id\": \"202\"\n" +
                        "\n" +
                        "}");

    }


    @Then("Send POST request to an endpoint {string}")
    public void sendPOSTRequestToAnEndpoint(String endpoint) {

        response =   specs.when().log().all().
                post(endpoint);

    }




    @Then("The application should contain expenses as {string}")
    public void theApplicationShouldContainExpensesAs( String rent) {

        response. then().log().all().
                assertThat().

                statusCode(equalTo(200)).
                body(containsString(rent));

    }

}
