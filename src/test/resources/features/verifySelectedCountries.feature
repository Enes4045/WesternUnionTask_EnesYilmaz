@wip
Feature: Verifying counrty filter option

  Scenario:Changing country page on the website
    Given User should launches on the given url
    When User should expand burger menu
    And User should be able to click Settings option
    And User should changes country to United States
    Then Verify User navigates to selected country

  Scenario: Open agent locations search
    Given User should launches on the given url
    When User should expand burger menu
    And User should be able to click Find locations option
    And User should enter the zip code
    And User clicks the Open now button
    Then Verify User can get the first agent's adress