#Author: Adrian Matos
@Account_registration @TPFinal_web
Feature: Account Registration of practice automation testing

  Background: Open the url in the browser
    Given The client is on home page

  @case_4
  Scenario Outline: Registration with empty password
    When Click on My Account Menu
    And Enter an Email Address "<email>" in textbox
    And Enter "<password>" in textbox
    And Click on Register button
    Then Registration must fail with a warning message "<warning_message>"

    Examples:
      | email             | password | warning_message                          |
      | test1@example.com |          | Error: Please enter an account password. |
      | test2@example.com |          | Error: Please enter an account password. |

  @case_5
  Scenario Outline: Registration with empty Email-id & password
    When Click on My Account Menu
    And Enter an Email Address "<email>" in textbox
    And Enter "<password>" in textbox
    And Click on Register button
    Then Registration must fail with a warning message "<warning_message>"

    Examples:
      | email | password | warning_message                              |
      |       |          | Error: Please provide a valid email address. |


