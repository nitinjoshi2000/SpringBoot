Feature: Verify springboot application using Cucumber

  @ReceiveUserDetails

  Scenario Outline: Send a valid Request to register user details
    Given I send a request to the URL "/registration" to register user details
    Then the response will return status 200 and id "<id>" and firstname "<firstname>" and lastname "<lastname>" and email "<email>" and password "<password>"
    Examples:
      | id  | firstname     | lastname  | email                      | password  |
      | 20  | Sudhanshu     | Pal       | sudhanshu@gmail.com        | 1234      |