Feature: Checkboxes
  Checking if there are any broken images on the web page


  Scenario: Search for broken images
    Given The Internet herokuApp page is opened
    When I click on "Checkboxes" link
    Then "Checkboxes" page should be opened
    Then I get actual checkbox statuses
    Then Close browser
