package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import org.junit.Assert;
import utilities.DBUtils;
import utilities.Driver;

import java.util.*;

public class KaterinaDBOnlyStepDefs {

    List<String> actualColumnNames;
    List<List<Object>> actualTableNames;

    @When("I retrieve column names for the {string} table for Employer and Income tab")
    public void iRetrieveColumnNamesForTheTableForEmployerAndIncomeTab(String table) {

        String query = "select employer_name, position, city, state, start_date, end_date, current_job," +
                "gross_monthly_income, monthly_over_time, monthly_bonuses, monthly_commision, monthly_dividents, income_source, amount," +
                "co_employer_name, co_position, co_city, co_state, co_start_date, co_end_date, co_current_job," +
                "c_gross_monthly_income, c_monthly_over_time, c_monthly_bonuses, c_monthly_commision, c_monthly_dividents, add_belong " +
                "from " + table + " limit 1;";
        actualColumnNames = DBUtils.getColumnNames(query);

//        System.out.println(actualColumnNames);

    }

    @Then("The names of the columns should be the following")
    public void theNamesOfTheColumnsShouldBeTheFollowing(List<String> expectedColumnNames) {

//        System.out.println(expectedColumnNames);

        Set<String> intersect = new HashSet<>(expectedColumnNames);
        intersect.removeAll(actualColumnNames);
        System.out.println("The correct column names should be: " + intersect);

        assertEquals(expectedColumnNames,actualColumnNames);

    }

    @When("I retrieve column names for the {string} table for EConsent tab")
    public void iRetrieveColumnNamesForTheTableForEConsentTab(String table) {

        String query = "select eConsent_declarer_FirstName, eConsent_declarer_LastName, " +
                "eConsent_declarer_Email from "+ table +";" ;
        actualColumnNames = DBUtils.getColumnNames(query);
//        System.out.println(actualColumnNames);

    }


}
