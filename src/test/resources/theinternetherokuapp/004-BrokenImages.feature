Feature: Search for broken images
  Checking if there are any broken images on the web page


  Scenario: Search for broken images
    Given The Internet herokuApp page is opened
    When I click on "Broken Images" link
    Then "Broken Images" page should be opened
    And I return list with broken images
    And Close browser
