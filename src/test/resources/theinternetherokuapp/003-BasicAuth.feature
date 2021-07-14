Feature: Basic auth test
  Pass login and password to basic auth by link


  Scenario: Log in using basic auth as admin
    When I log in as user "admin" with password "admin"
    Then User is logged succesfully

  Scenario: Log in using basic auth as unauthorized person
    When I log in as user "test" with password "test"
    Then User is not logged in