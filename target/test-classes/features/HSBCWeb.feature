@androidbrowser
Feature: HSBC Website page loading

  Scenario: To verify HSBC Credit card page is loading sucessfully
    Given hsbc website page is open
    When user clicks on the online banking button
    Then Online banking page should open
