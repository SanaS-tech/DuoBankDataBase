package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KaterinaApplicationPage;
import pages.KaterinaLoginPage;
import pages.SanaPage;
import utilities.BrowserUtils;
import utilities.DBUtils;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SanaDBUpdatePIStepDefs {

    String maritalStatusUpdated;
    String emailUpdated;


    @When("The admin updates the marital status to {string} of a user with firstname {string} and lastname {string}")
    public void theAdminUpdatesTheMaritalStatusToOfAUserWithFirstnameAndLastname(String b_maritalStatus, String firstName, String lastName) {

        String query = "update tbl_mortagage set b_marital = '"+ b_maritalStatus +"' where b_firstName='"+ firstName +"' " +
                "and b_lastName = '"+ lastName + "';" ;

        maritalStatusUpdated = b_maritalStatus;

        DBUtils.updateQuery(query);

    }



    @Then("The admin views the appropriate application")
    public void theAdminViewsTheAppropriateApplication() {
        SanaPage sp = new SanaPage();

        BrowserUtils.waitForPageToLoad(10);
        sp.emailAddressLogIn.sendKeys("teambinland@gmail.com");
        sp.passwordLogIn.sendKeys("codelab99");
        sp.login.click();
        BrowserUtils.waitFor(5);
        sp.applicationListButton.click();
        sp.viewDetailsMidland.click();
        BrowserUtils.scroll(0, 200);

    }

    @Then("The admin sees the updated changes in the application")
    public void theAdminSeesTheUpdatedChangesInTheApplication() {
        SanaPage sp = new SanaPage();
        String uiMaritalStatus = sp.bMaritalStatus.getText();
        assertEquals(maritalStatusUpdated,uiMaritalStatus);

        String query = "update tbl_mortagage set b_marital = 'Separated' where b_firstName='midland' " +
                "and b_lastName = 'midlandLN';" ;
        DBUtils.updateQuery(query);

    }



/////////////////


    @When("The admin updates the email to {string} of a user with firstname {string} and lastname {string}")
    public void theAdminUpdatesTheEmailToOfAUserWithFirstnameAndLastname(String email, String firstName, String lastName) {

        String query = "update tbl_mortagage set b_email = '"+ email +"' where b_firstName='"+ firstName +"' " +
                "and b_lastName = '"+ lastName + "';" ;

        emailUpdated = email;

        DBUtils.updateQuery(query);

    }



    @Then("The admin sees the appropriate application")
    public void theAdminSeesTheAppropriateApplication() {
        SanaPage sp = new SanaPage();

        BrowserUtils.waitForPageToLoad(10);
        sp.emailAddressLogIn.sendKeys("teambinland@gmail.com");
        sp.passwordLogIn.sendKeys("codelab99");
        sp.login.click();
        BrowserUtils.waitFor(5);
        sp.applicationListButton.click();
        sp.viewDetailsOffland.click();
        BrowserUtils.scroll(0, 200);

    }

    @Then("The admin views the updated changes in the application")
    public void theAdminViewsTheUpdatedChangesInTheApplication() {
        SanaPage sp = new SanaPage();
        String uiemail= sp.bEmail.getText();
        assertEquals(emailUpdated,uiemail);

        String query = "update tbl_mortagage set b_email = 'teambofflandRevert@gmailcom' where b_firstName='offland' " +
                "and b_lastName = 'offlandLN';" ;
        DBUtils.updateQuery(query);

    }







}
