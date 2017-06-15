@androidbrowser
Feature: HSBC Website different page loading

  Scenario: To verify HSBC About HSBC page is loading sucessfully
    Given hsbc website page is open
    When user clicks on the about hsbc link
    Then About HSBC page should open
    
  Scenario: To verify HSBC Our purpose page is loading sucessfully
    Given hsbc website page is open
    When user clicks on the our purpose link
    Then Our purpos page should open
