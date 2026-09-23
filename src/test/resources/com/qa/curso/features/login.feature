Feature: Practice login

  Scenario: Successful login
    Given the login page is open
    When I enter the user "admin" and the password "1234"
    Then I see the message "Bienvenido admin"

  Scenario Outline: Probando combinaciones de login
    Given the login page is open
    When I enter the user "<usuario>" and the password "<clave>"
    Then I see the message "<mensaje>"

    Examples:
      | usuario | clave | mensaje                     |
      | admin   | 1234  | Bienvenido admin            |
      | admin   | 9999  | Usuario o clave incorrectos |
      | admin   | wrong | Usuario o clave incorrectos |
      |         | 1234  | Usuario o clave incorrectos |