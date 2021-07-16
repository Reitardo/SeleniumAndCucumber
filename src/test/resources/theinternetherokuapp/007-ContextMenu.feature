Feature: Context Menu
  Right click on context menu to see js window


  Scenario: Search for broken images
    Given The Internet herokuApp page is opened
    When I click on "Context Menu" link
    Then "Context Menu" page should be opened
    When I right click on context menu
    Then i get javascript alert
    And Close browser
