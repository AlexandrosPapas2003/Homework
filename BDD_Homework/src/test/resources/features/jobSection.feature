Feature: Verification of the presence of the Job section in the main menu

  Scenario: Verify that the 'Job' section is visible in the OrangeHRM main menu
    Given user logs in OrangeHRM page
    When user clicks on 'Login' button
    Then the user can see Job section in the main menu
