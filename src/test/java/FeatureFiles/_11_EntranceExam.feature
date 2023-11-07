#senaryo
#  Exam formunun çalışmasını test edin
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Exam functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Exam Create and Delete
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceEzamsTwo |

    And Click on the element in Dialog
      | addButton |

    And User sending the keys in Dialog
      | nameInput | yasExam |

    And Click on the element in Dialog
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |

    And Click on the element in Dialog
      | saveButton |

    Then Success message should be displayed
#   silme ekranına ulaşmak için tekrar navigate yapıldı
    And Click on the element in LeftNav
      | entranceExamsOne |
      | setupTwo         |
      | entranceEzamsTwo |

    And User delete the element from Dialog
      | yasExam |

    And Click on the element in Dialog
      | searchAcademicPeriod  |
      | academicPeriod1 |

    Then Success message should be displayed



