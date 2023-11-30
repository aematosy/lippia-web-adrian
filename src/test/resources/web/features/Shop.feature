#Author: Adrian Matos
@Shop @TPFinal_web
Feature: shop page of practice automation testing

  Background: Open the url in the browser
    Given The client is on home page

  @case_11
  Scenario Outline: Shop-Add to Basket-View Basket through Item link
    Given Click on Shop Menu
    When Click on the Add "<bookTitle>" To Basket button in shop page
    Then User can view that Book in the menu item with price
    When Click on Item link to proceed to checkout page
    Then Now user can find total and subtotal values just above the Proceed to Checkout button
    And The total always < subtotal because taxes are added in the subtotal
    When Click on Proceed to Checkout button which navigates to payment gateway page
    Then User can view Billing Details, Order Details, Additional details, and Payment gateway details
    When User fill his details in billing details from: "<first_name>", "<last_name>", "<company>", "<email>", "<phone>", "<country>", "<address>", "<city>", "<state>", "<zipcode>"
    And User select payment like "<payment_method>"
    And Click on Place Order button to complete process
    Then User navigate to Order confirmation page with order details, bank details, customer details, and billing details

    Examples:
      | bookTitle            | first_name | last_name | company   | email           | phone     | country | address      | city     | state    | zipcode | payment_method       |
      | Mastering JavaScript | Adrian     | Matos     | TEST      | test1@gmail.com | 961478521 | Peru    | siempre viva | Lima     | Lima     | 15001   | Direct Bank Transfer |
      | Thinking in HTML     | Adrian     | Matos     | TEST      | test2@gmail.com | 961478522 | Peru    | siempre viva | Arequipa | Arequipa | 15005   | Check Payments       |
      | Selenium Ruby        | Adrian     | Matos     | TEST      | test3@gmail.com | 961478523 | Peru    | siempre viva | Tacna    | Tacna    | 15009   | Cash on Delivery     |
      | HTML5 Forms          | Adrian     | Matos     | TESTFINAL | test3@gmail.com | 147852369 | Peru    | siempre viva | Lima     | Lima     | 15009   | Check Payments       |

  @case_12
  Scenario Outline: Verify total, subtotal, and tax rates for book purchase
    Given Click on Shop Menu
    When Click on the Add "<bookTitle>" To Basket button in shop page
    Then User can view that Book in the menu item with price
    When Click on Item link to proceed to checkout page
    Then Now user can find total and subtotal values just above the Proceed to Checkout button
    And The total is less than the subtotal because taxes are added in the subtotal
    And Click on Proceed to Checkout button which navigates to payment gateway page
    And User fill his details in billing details country from: "<Country>"
    Then Validate Taxes for India and other countries: "<taxRate>"

    Examples:
      | bookTitle        | Country | taxRate |
      | HTML5 Forms      | India   | 2%      |
      | Thinking in HTML | Peru    | 5%      |