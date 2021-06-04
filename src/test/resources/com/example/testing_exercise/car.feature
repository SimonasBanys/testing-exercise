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

  Scenario Template: User checks car details against existing list
    When user goes to the website and uses car <index>
    Then user checks if car <index> has been repainted

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |

  Scenario Template: User checks car details against existing list
    When user goes to the website and uses car <index>
    Then user checks if car <index> make is the same

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |

  Scenario Template: User checks car details against existing list
    When user goes to the website and uses car <index>
    Then user checks if car <index> model is the same

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |

  Scenario Template: User checks car details against existing list
    When user goes to the website and uses car <index>
    Then user checks if car <index> colour is the same

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |

  Scenario Template: User checks car details against existing list
    When user goes to the website and uses car <index>
    Then user checks if car <index> year is the same

    Examples:
      | index |
      | 0   |
      | 1   |
      | 2   |
      | 3   |