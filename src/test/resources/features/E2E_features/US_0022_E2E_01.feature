@E2E_US22_23
Feature: US22 UI ve Database End to End test
  @UI
  Scenario: UI Admin Ekleme
    Given admin login olur
    When admin verilen bilgileri girer
    And admin submit butonuna basar
    Then admin adminin eklenip eklenmedigini dogrular

  Scenario Outline: Database Admin Dogrulama
    Given database e baglan
    When username "<username>" ile admini getir
    Then bodynin bunlari icerdigini dogrula birthday "<birthday>", birthplace "<birthplace>", gender "<gender>", name "<name>", phoneNubmer"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username | birthday   | birthplace | gender | name       | phoneNumber | ssn | surname |
      | username | 2002-01-24 | bursa      | 0      | mehmet ali | phoneNumber | ssn | karasu  |