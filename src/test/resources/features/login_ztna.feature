Feature: Login feature

  Scenario Outline: user tries to login
    Given user is on login page
    When user tries to login using <parameter>
    Then user should be logged in

    Examples:
    | parameter |
    | Fahad Login Credentials |