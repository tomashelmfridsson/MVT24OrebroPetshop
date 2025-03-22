Feature: Basketball

  Scenario: Register a user
    Given I am at webpage "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When I register a user
    Then it confirms Ok


