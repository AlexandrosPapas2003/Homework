Feature: Review section on the 'Performance' page

  Scenario: Verify that the 'review' section is present on the 'Performance' page of OrangeHRM.
    Given user logs in OrangeHRM page
    When Performance section in the main menu was clicked
    And user was redirected to Performance page
    Then the review section is present
