Feature: Verify springboot application using Cucumber

  @SendProductDetails
  Scenario Outline: Send a valid Request to get product details
    Given I send a request to the URL "Product/products" to get product details
    Then the response will return status 200 and id <id> and name "<name>" and quantity <quantity> and price <price>
#    And I send a request to the URL "/productByName/Tv" to get product details
#    Then the response will return status 200 and id <id> and name "<name>" and quantity <quantity> and price <price>

    Examples:
    |id | name   | quantity | price |
    | 1 | Tv     | 2        | 30000 |
    | 2 | Mobile | 3        | 40000 |