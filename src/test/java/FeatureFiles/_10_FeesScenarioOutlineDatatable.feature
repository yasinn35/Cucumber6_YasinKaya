#Senaryo:
#  Daha önceki Fee Functionality Senaryosunu
#  name, code, intCode ve priority için 5 farklı kombinasyon için çalıştırınız.

Feature: Fees multiple values functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Fee Functionality
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | <name>     |
      | codeInput       | <code>     |
      | integrationCode | <intCode>  |
      | priorityCode    | <priority> |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | <name> |

    Then Success message should be displayed

    Examples:
      | name    | code | intCode  | priority |
      | yasko357 | 3456 | PayPal   | 9845     |
      | yasko358 | 9876 | Cash     | 3498     |
      | yasko359 | 2345 | Cheque   | 1290     |
      | yasko352 | 9988 | ApplaPay | 2157     |
      | yasko353 | 3355 | Crypto   | 6578     |