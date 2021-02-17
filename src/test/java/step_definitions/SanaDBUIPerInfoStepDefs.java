package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.DBUtils;
import pages.SanaPage;
import java.util.List;
import java.util.Map;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;

public class SanaDBUIPerInfoStepDefs {

    String name;
    String eMail;
    String DoB;
    String maritalStatus;
    String rentOrOwn;
    String monthlyExp;

    @Given("The user logs into the account")
    public void theUserLogsIntoTheAccount() {
        SanaPage sp = new SanaPage();

        BrowserUtils.waitForPageToLoad(10);
        sp.emailAddressLogIn.sendKeys("teambinland@gmail.com");
        sp.passwordLogIn.sendKeys("codelab99");
        sp.login.click();
        BrowserUtils.waitFor(5);
    }


    @When("The user clicks on the Application List and views their application")
    public void theUserClicksOnTheApplicationListAndViewsTheirApplication() {
        SanaPage sp = new SanaPage();

        sp.applicationListButton.click();


    }
    @Then("The user is able to verify their personal info")
    public void theUserIsAbleToVerifyTheirPersonalInfo() {
        SanaPage sp = new SanaPage();
        sp.viewDetailsInland.click();

        BrowserUtils.scroll(0, 200);

        name = sp.bName.getText();
        eMail = sp.bEmail.getText();
        DoB = sp.bDateOfBirth.getText();
        maritalStatus = sp.bMaritalStatus.getText();

    }
    @Then("The user details should be correctly mapped in the mortgage table of database")
    public void theUserDetailsShouldBeCorrectlyMappedInTheMortgageTableOfDatabase() {


        String request = "select b_firstName, b_email, b_dob, b_marital from tbl_mortagage where user_id='2508'";

         List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);

        Map<String, Object> map = list.get(0);

        String dbFirstName = (String) map.get("b_firstName");
        String dbEmail = (String) map.get("b_email");
        String dbDateOfBirth = (String) map.get("b_dob");
        String dbMarital = (String) map.get("b_marital");


        assertEquals(name, dbFirstName);
        assertEquals(eMail, dbEmail);
        assertEquals(DoB, dbDateOfBirth);
        assertEquals(maritalStatus, dbMarital);

    }






}
