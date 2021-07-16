Feature: A/B Testing feature page
  Testing A/B Testing page

  Scenario: Verify text on A/B Testing page
    Given The Internet herokuApp page is opened
    When I click on "A/B Testing" link
    Then I should show "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through)."
    Then Close browser

