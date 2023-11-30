#Author: Adrian Matos
@Account_login @TPFinal_web
Feature: Account Login of practice automation testing

  Background: Open the url in the browser
    Given The client is on home page

  @case_7
  Scenario Outline: Login-Handles case sensitive "<Test_cases>"
    When Click on My Account Menu
    And Enter username "<username>" in username textbox
    And Enter password "<password>" in the password textbox
    And Click on login button
    Then Login must fail saying incorrect with message "<error_message>".

    Examples:
      | Test_cases                        | username | password | error_message                                                                                                                  |
      | Existing user with wrong password | Test     | Pass123  | Error: The password you entered for the username Test is incorrect. Lost your password?                                        |
      | Non-existent user                 | amATos   | Abc123   | Error: The username amATos is not registered on this site. If you are unsure of your username, try your email address instead. |

  @case_8
  Scenario Outline: Login-Authentication
    When Click on My Account Menu
    And Enter username "<username>" in username textbox
    And Enter password "<password>" in the password textbox
    And Click on login button
    And Click on Logout button
    And Press back button
    Then User shouldn't be signed in to his account

    Examples:
      | username  | password         |
      | Testfinal | Test147TPfinal.* |

