@androidbrowser
Feature: HSBC Website page loading successfully

  Scenario: To verify HSBC Online banking page is loading sucessfully
    Given hsbc website page is open
    When user clicks on the online banking button
    Then Online banking page should open

  Scenario: To verify HSBC Life at HSBC page is loading sucessfully
    Given hsbc website page is open
    When user clicks on the digital and innovation link
    Then Digital and innovation page should open
