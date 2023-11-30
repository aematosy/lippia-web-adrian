#Author: Adrian Matos
@Account @TPFinal_web
Feature: Account page from practice automation testing

  Background: Open the url in the browser
    Given The client is on home page

  @case_7
  Scenario Outline: User login, access account details, and change password
    When Click on My Account Menu
    And Enter username "<username>" in username textbox
    And Enter password "<password>" in the password textbox
    And Click on login button
    Then User must successfully login to the web page
    And Click on Account details
    Then User can access the Account Details section

    Examples:
      | username  | password         |
      | Testfinal | Test147TPfinal.* |

  @case_8
  Scenario Outline: User login and logout
    When Click on My Account Menu
    And Enter username "<username>" in username textbox
    And Enter password "<password>" in the password textbox
    And Click on login button
    Then User must successfully login to the web page
    And Click on Logout button
    Then User successfully comes out from the site

    Examples:
      | username  | password         |
      | Testfinal | Test147TPfinal.* |

