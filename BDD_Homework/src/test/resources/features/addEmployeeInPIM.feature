Feature: Validation of 'Employee Id' field in PIM Add Employee form

  Scenario: Verify that the user can't add an employee in 'PIM' when 'Employee Id' field is empty
    Given user logs in OrangeHRM page
    And user is redirected to Dashboard page
    And PIM is clicked
    And user is redirected to PIM page
    And Add employee is clicked
    And user is redirected to Add employee page
    When Create Login Details toggle is clicked
    And user fills in the form with
      | firstName  | lastName     | username | password |
      | Eduard     | Eduardovich  | edu130   | bubu1234 |
    And Employee Id field is empty
    And Save button is clicked
    Then error message is displayed
