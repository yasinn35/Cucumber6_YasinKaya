Feature: DataTable Ornek

  Scenario: Users List
    When Write username "yasin"
    And Write username and Password "ismet" and "1234"


    And  Write username as DataTable

    | ismet  |
    | mehmet |
    | ayse   |
    | fatma  |

    And Write username and password as DataTable

    | ismet  | 1234   |
    | mehmet | 23234  |
    | ayse   | 126745 |
    | fatma  | 1234   |

