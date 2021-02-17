Feature:  Column names

  @katerina_db_only
  Scenario: Verify column names per business requirement document

    When I retrieve column names for the "tbl_mortagage" table for Employer and Income tab
    Then The names of the columns should be the following
      | employer_name           |
      | position                |
      | city                    |
      | state                   |
      | start_date              |
      | end_date                |
      | current_job             |
      | gross_monthly_income    |
      | monthly_overtime        |
      | monthly_bonuses         |
      | monthly_commission      |
      | monthly_dividends       |
      | income_source           |
      | amount                  |
      | co_employer_name        |
      | co_position             |
      | co_city                 |
      | co_state                |
      | co_start_date           |
      | co_end_date             |
      | co_current_job          |
      | co_gross_monthly_income |
      | co_monthly_overtime     |
      | co_monthly_bonuses      |
      | co_monthly_commission   |
      | co_monthly_dividends    |
      | add_belong              |

  @katerina_db_only
  Scenario: Verify table names per business requirement document

    When I retrieve column names for the "tbl_mortagage" table for EConsent tab
    Then The names of the columns should be the following
      | eConsent_declarer_FirstName |
      | eConsent_declarer_LastName  |
      | eConsent_declarer_Email     |