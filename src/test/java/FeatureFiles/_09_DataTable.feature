Feature: DataTable Functionality

  Background: #before senaryo
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country
    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | countries  |

    And Click on the element in Dialog

      | addButton |

    And  User sending the keys in Dialog
      | nameInput | ismetdfgh |
      | codeInput | i21313    |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And  User delete the element from Dialog
      | ismetdfgh |

    Then Success message should be displayed


  Scenario: Create Nationality
    And Click on the element in LeftNav
      | setup         |
      | parameters    |
      | nationalities |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | yaskosdf7 |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | yaskosdf7 |

    Then Success message should be displayed

  Scenario: Fee Functionality

    And Click on the element in LeftNav
      | setup      |
      | parameters |
      | fees       |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput       | yasko35 |
      | codeInput       | 76543   |
      | integrationCode | 36345   |
      | priorrityCode   | 789656  |

    And Click on the element in Dialog
      | toggleBar  |
      | saveButton |

    Then Success message should be displayed

    And User delete the element from Dialog
      | yasko35 |

    Then Success message should be displayed
