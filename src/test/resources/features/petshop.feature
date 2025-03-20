Feature: Add items in Petshop

  Scenario: Add one item not sold out to basket
    Given I am at this webpage "https://www.petnecessity.co.uk/"
    And I close all Popups for necessity
    And I am at the "Pets Shop!" startpage
    When I add item "KONG Pull-A-Partz Pinata" go to cart
    Then The cart includes 1 "KONG Pull-A-Partz Pinata"

