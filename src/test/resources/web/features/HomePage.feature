#Author: Adrian Matos
@HomePage @TPFinal_web
Feature: HomePage of practice automation testing

  Background: Open the url in the browser
    Given The client is on home page

  @case_17
  Scenario Outline: Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
    And The Home page must contain only "<number_of_arrivals>" Arrivals
    When Click the image in the Arrival: "<new_arrival>"
    Then Test whether it is navigating to the next page where the user can add that book to his basket
    And User validate can add that book to his basket
    When Click on the Add To Basket button which adds that book to your basket
    Then User can view that Book in the Menu item with price
    When Click on Item link which navigates to proceed to checkout page
    Then Now user can find total and subtotal values just above the Proceed to Checkout button
    And The total always < subtotal because taxes are added in the subtotal
    When Click on Proceed to Checkout button which navigates to payment gateway page
    Then User can view Billing Details, Order Details, Additional details, and Payment gateway details
    When User fill his details in billing details from: "<first_name>", "<last_name>", "<company>", "<email>", "<phone>", "<country>", "<address>", "<city>", "<state>", "<zipcode>"
    And User select payment like "<payment_method>"
    Then User can see order details in Your Order section and add coupons if any

    Examples:
      | number_of_arrivals | new_arrival          | first_name | last_name | company | email           | phone     | country | address    | city     | state    | zipcode | payment_method          |
      | 3                  | Selenium Ruby        | Adrian     | Matos     | TEST    | test1@gmail.com | 961478521 | Peru    | calle test | Lima     | Lima     | 15001   | Direct Bank Transfer    |


  @case_18
  Scenario Outline: Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
    And The Home page must contain only "<number_of_arrivals>" Arrivals
    When Click the image in the Arrival: "<new_arrival>"
    Then Test whether it is navigating to the next page where the user can add that book to his basket
    And User validate can add that book to his basket
    When Click on the Add To Basket button which adds that book to your basket
    Then User can view that Book in the Menu item with price
    When Click on Item link which navigates to proceed to checkout page
    Then Now user can find total and subtotal values just above the Proceed to Checkout button
    And The total always < subtotal because taxes are added in the subtotal
    When Click on Proceed to Checkout button which navigates to payment gateway page
    Then User can view Billing Details, Order Details, Additional details, and Payment gateway details
    When User fill his details in billing details from: "<first_name>", "<last_name>", "<company>", "<email>", "<phone>", "<country>", "<address>", "<city>", "<state>", "<zipcode>"
    And User select payment like "<payment_method>"
    And Click on Place Order button to complete process
    Then User navigate to Order confirmation page with order details, bank details, customer details, and billing details

    Examples:
      | number_of_arrivals | new_arrival          | first_name | last_name | company | email           | phone     | country | address    | city     | state    | zipcode | payment_method          |
      | 3                  | Selenium Ruby        | Adrian     | Matos     | TEST    | test1@gmail.com | 961478521 | Peru    | calle test | Lima     | Lima     | 15001   | Direct Bank Transfer    |
      | 3                  | Thinking in HTML     | Adrian     | Matos     | TEST    | test2@gmail.com | 961478522 | Peru    | calle test | Arequipa | Arequipa | 15005   | Check Payments          |
      | 3                  | Mastering JavaScript | Adrian     | Matos     | TEST    | test3@gmail.com | 961478523 | Peru    | calle test | Loreto   | Loreto   | 15002   | Cash on Delivery        |
      #| 3                  | Selenium Ruby        | Adrian     | Matos     | TEST    | test@gmail.com  | 961478521 | country | calle test | Lima     | state    | 15004   | PayPal Express Checkout |
