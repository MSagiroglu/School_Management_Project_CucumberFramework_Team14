@E2E_US22_23
Feature:US23 UI ve Database End to End test
  @UI
  Scenario: UI Admin ile Vice Dean Ekleme
    Given admin login olur
    When admin menuye tiklar ve ardindan vice dean managementa tiklar
    And admin vice dean eklemek icin verilen bilgileri girer
    And admin submit butonuna basar
    Then admin vice deanin eklenip eklenmedigini dogrular

  Scenario Outline: Database Vice deani Dogrulama
    Given connect to database
    When username "<username>" ile vice deani getir
    Then vice dean bodynin bunlari icerdigini dogrula birthday "<birthday>", birthplace "<birthplace>", gender "<gender>", name "<name>", phoneNumber"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username | birthday   | birthplace | gender | name       | phoneNumber | ssn | surname |
      | username | 2002-01-24 | izmir      | 0      | mehmet ali | phoneNumber | ssn | karasu  |