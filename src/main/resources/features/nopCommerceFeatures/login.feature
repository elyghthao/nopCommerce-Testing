Feature: User Login


  Scenario: Successful Login
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "testy@gmail.com", password: "test@123")
    And the user clicks on the Login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
    And the user is done

  Scenario: Successful Logout
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "testy@gmail.com", password: "test@123")
    And the user clicks on the Login button
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
    And the user should be able to click on the logout
    And the user is done
