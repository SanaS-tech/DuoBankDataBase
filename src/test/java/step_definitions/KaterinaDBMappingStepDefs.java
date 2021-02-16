package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import pages.KaterinaApplicationPage;
import pages.KaterinaLoginPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class KaterinaDBMappingStepDefs {

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I enter {string} for email address and {string} for password and click on login")
    public void iEnterForEmailAddressAndForPasswordAndClickOnLogin(String email, String password) {

        KaterinaLoginPage lp = new KaterinaLoginPage();
        lp.email.sendKeys(email);
        lp.password.sendKeys(password);
        lp.loginButton.click();

    }

    @When("I click on Application List and click on View Details for borrower {string}")
    public void iClickOnApplicationListAndClickOnViewDetailsForBorrower(String borrower) {
        KaterinaApplicationPage ap = new KaterinaApplicationPage();
        ap.applicationList.click();
        ap.clickOnBorrower(borrower);

    }

    @Then("I should land on the Mortgage Application page")
    public void iShouldLandOnTheMortgageApplicationPage() {
        assertTrue(Driver.getDriver().getPageSource().contains("Application Details"));

    }

    @Then("The income info should be correctly mapped in the users table of database for {string} {string}")
    public void theIncomeInfoShouldBeCorrectlyMappedInTheUsersTableOfDatabaseFor(String firstName, String lastName) {
        KaterinaApplicationPage ap = new KaterinaApplicationPage();

        String expectedGrossMonthlyIncome = ap.grossMonthlyIncome.getText();
        String expectedMonthlyOvertime = ap.monthlyOvertime.getText();
        String expectedMonthlyBonuses = ap.monthlyBonuses.getText();
        String expectedMonthlyCommission = ap.monthlyCommission.getText();
        String expectedMonthlyDividends = ap.monthlyDividends.getText();

        String request = "select gross_monthly_income, monthly_over_time, monthly_bonuses, monthly_commision, monthly_dividents " +
                "from tbl_mortagage where b_firstName = '"+firstName+"' and b_lastName = '"+lastName+"';" ;

        final List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);
        Map<String, Object> map = list.get(0);

        String actualGrossMonthlyIncome =  (String) map.get("gross_monthly_income");
        String actualMonthlyOvertime =  (String) map.get("monthly_over_time");
        String actualMonthlyBonuses =  (String) map.get("monthly_bonuses");
        String actualMonthlyCommission =  (String) map.get("monthly_commision");
        String actualMonthlyDividends =  (String) map.get("monthly_dividents");

        assertEquals(expectedGrossMonthlyIncome, actualGrossMonthlyIncome);
        assertEquals(expectedMonthlyOvertime, actualMonthlyOvertime);
        assertEquals(expectedMonthlyBonuses, actualMonthlyBonuses);
        assertEquals(expectedMonthlyCommission, actualMonthlyCommission);
        assertEquals(expectedMonthlyDividends, actualMonthlyDividends);


    }

    @Then("The econsent info should be correctly mapped in the users table of database for {string} {string}")
    public void theEconsentInfoShouldBeCorrectlyMappedInTheUsersTableOfDatabaseFor(String firstName, String lastName) {

        KaterinaApplicationPage ap = new KaterinaApplicationPage();

        String expectedDeclarer = ap.declarer.getText();
        String expectedDeclarerFirstName = ap.declarerFirstName.getText();
        String expectedDeclarerLastName = ap.declarerLastName.getText();
        String expectedDeclarerEmail = ap.declarerEmail.getText();

        String request = "select eConsent_declarer, eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email " +
                "from tbl_mortagage where b_firstName = '"+firstName+"' and b_lastName = '"+lastName+"';" ;

        final List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);
        Map<String, Object> map = list.get(0);

        String actualDeclarer =  (String) map.get("eConsent_declarer");
        String actualDeclarerFirstName =  (String) map.get("eConsent_declarer_FirstName");
        String actualDeclarerLastName =  (String) map.get("eConsent_declarer_LastName");
        String actualDeclarerEmail =  (String) map.get("eConsent_declarer_Email");

        assertEquals(expectedDeclarer, actualDeclarer);
        assertEquals(expectedDeclarerFirstName, actualDeclarerFirstName);
        assertEquals(expectedDeclarerLastName, actualDeclarerLastName);
        assertEquals(expectedDeclarerEmail, actualDeclarerEmail);

    }

}
