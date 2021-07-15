Feature: Search for broken images
  Checking if there are any broken images on the web page


  Scenario: Search for broken images
    Given The Internet herokuApp page is opened
    When I click on "Broken Images" object
    Then "Broken Images" page should be opened
    Then I return list with broken images
    Then Close browser
