Feature: Jewelery Rental

  Scenario: User rents jewelry for 2 days
    Given the user has selected which jewelery to rent
    When the user decides to rent the jewelery for 2 days
    And the user clicks on the rent button
    Then the user should navigate to the shopping cart
    And click checkouts as a guest
    And complete the checkout by entering in all of the data

