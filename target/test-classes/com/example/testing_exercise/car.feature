Feature: Checking car details

  Scenario Template: User goes to cartaxcheck.co.uk to check car details
    When user goes to the website and uses car <index>
    Then user checks if the car <index> exists in the list

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |

  Scenario Template: User compares car from input to output at the same index
    When user goes to the website and uses car <index>
    Then user checks if the car <index> is the same in input and output

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |