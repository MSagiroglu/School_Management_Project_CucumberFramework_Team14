Feature: US22 Admin Ekleme
  Scenario: TC01 Admin Ekleme
    Given admin login olur
    When admin verilen bilgileri girer
    And admin submit butonuna basar
    Then admin adminin eklenip eklenmedigini dogrular