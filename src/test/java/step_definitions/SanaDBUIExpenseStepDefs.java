package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SanaPage;
import utilities.BrowserUtils;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SanaDBUIExpenseStepDefs {

    String name;
    String eMail;
    String DoB;
    String maritalStatus;
    String rentOrOwn;
    String monthlyExp;

    @Given("The User logs into the account")
    public void theUserLogsIntoTheAccount() {
        SanaPage sp = new SanaPage();

        BrowserUtils.waitForPageToLoad(10);
        sp.emailAddressLogIn.sendKeys("teambinland@gmail.com");
        sp.passwordLogIn.sendKeys("codelab99");
        sp.login.click();
        BrowserUtils.waitFor(5);
    }


    @When("The User clicks on the Application List and views their application")
    public void theUserClicksOnTheApplicationListAndViewsTheirApplication() {
        SanaPage sp = new SanaPage();

        sp.applicationListButton.click();


    }


    ////////////////TC2///////////////////////



    @Then("The user is able to verify their expense")
    public void theUserIsAbleToVerifyTheirExpense() {

        SanaPage sp = new SanaPage();
        sp.viewDetailsInland.click();

        BrowserUtils.scroll(0, 300);

        rentOrOwn = sp.bRentOwn.getText();
        monthlyExp = sp.bMonthlyExpense.getText();

          //  System.out.println(rentOrOwn);
          //  System.out.println(monthlyExp);


    }



    @Then("The user expense amount should be correctly mapped in the mortgage table of database")
    public void theUserExpenseAmountShouldBeCorrectlyMappedInTheMortgageTableOfDatabase() {


        String request = "select rent_own_status, monthly_rental_payment from tbl_mortagage where id='202'";

        List<Map<String, Object>> list = DBUtils.getQueryResultMap(request);

        Map<String, Object> map = list.get(0);

        String dbRentStatus = (String) map.get("rent_own_status");
        String dbExpense = (String) map.get("monthly_rental_payment");


        assertEquals(monthlyExp, dbExpense);
     //   assertEquals(rentOrOwn, dbRentStatus);

    }

















}
