package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.KaterinaApplicationPage;
import pages.KaterinaLoginPage;
import utilities.DBUtils;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KaterinaDBUpdateStepDefs {

    String monthlyBonuses;
    String monthlyDividends;
    String email;


    @When("I update monthly bonuses with {string}, monthly dividends with {string} for a user with first name {string} and last name {string}")
    public void iUpdateMonthlyBonusesWithMonthlyDividendsWithForAUserWithFirstNameAndLastName(String monthlyBonuses,
                                                                                              String monthlyDividends,
                                                                                              String firstName,
                                                                                              String lastName) {

        String query = "update tbl_mortagage set monthly_bonuses = '"+ monthlyBonuses + "', monthly_dividents = '" + monthlyDividends +
                "' where b_firstName = '" + firstName + "' and b_lastName = '" + lastName + "';" ;

        this.monthlyBonuses = monthlyBonuses;
        this.monthlyDividends = monthlyDividends;


        DBUtils.updateQuery(query);


    }

    @Then("The same income info on the UI should be correct")
    public void theSameInfoOnTheUIShouldBeCorrect() {

        new KaterinaLoginPage().email.sendKeys("bsmith@gmail.com");
        new KaterinaLoginPage().password.sendKeys("bsmith123");
        new KaterinaLoginPage().loginButton.click();
        new KaterinaApplicationPage().applicationList.click();
        new KaterinaApplicationPage().clickOnBorrower("2");
        assertTrue(Driver.getDriver().getPageSource().contains("Application Details"));
        assertEquals(this.monthlyBonuses,new KaterinaApplicationPage().monthlyBonuses.getText());
        assertEquals(this.monthlyDividends,new KaterinaApplicationPage().monthlyDividends.getText());

    }

    @When("I update email with {string} for a user with first name {string} and last name {string}")
    public void iUpdateEmailWithForAUserWithFirstNameAndLastName(String email, String firstName, String lastName) {

        String query = "update tbl_mortagage set eConsent_declarer_Email = '"+ email + "' " +
                "where b_firstName = '" + firstName + "' and b_lastName = '" + lastName + "';" ;

        this.email = email;

        DBUtils.updateQuery(query);

    }

    @Then("The same eConsent info on the UI should be correct")
    public void theSameEConsentInfoOnTheUIShouldBeCorrect() {
        new KaterinaLoginPage().email.sendKeys("bsmith@gmail.com");
        new KaterinaLoginPage().password.sendKeys("bsmith123");
        new KaterinaLoginPage().loginButton.click();
        new KaterinaApplicationPage().applicationList.click();
        new KaterinaApplicationPage().clickOnBorrower("2");
        assertTrue(Driver.getDriver().getPageSource().contains("Application Details"));
        assertEquals(this.email,new KaterinaApplicationPage().declarerEmail.getText());
    }



}
