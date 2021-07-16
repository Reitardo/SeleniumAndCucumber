Feature: Add and Remove elements
  Basic tests for adding and removing elements from the page


  Scenario: Add/Remove Elements - single add
    Given The Internet herokuApp page is opened
    When I click on "Add/Remove Elements" link
    Then "Add/Remove Elements" page should be opened
    When I click on Add Element button
    Then Delete object is added
    Then Delete object list contains 1 button in list
    Then Close browser


  Scenario: Add/Remove Elements - single add
    Given The Internet herokuApp page is opened
    When I click on "Add/Remove Elements" link
    Then "Add/Remove Elements" page should be opened
    When I click on Add Element button 5 times
    Then Delete object list contains 5 button in list
    Then Close browser

  Scenario: Single delete
    Given The Internet herokuApp page is opened
    When I click on "Add/Remove Elements" link
    Then "Add/Remove Elements" page should be opened
    When I click on Add Element button
    Then Delete object is added
    Then Delete object list contains 1 button in list
    When I click on Delete button
    Then Button is removed
    Then Close browser