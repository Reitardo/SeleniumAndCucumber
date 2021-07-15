Feature: Basic auth test
  Pass login and password to basic auth by link


  Scenario: Log in using basic auth as admin
    When I log in as user "admin" with password "admin"
    Then User is logged successfully
    Then Close browser
