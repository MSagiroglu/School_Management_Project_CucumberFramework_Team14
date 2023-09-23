@E2E_US22_23
Feature: US23 API ve Database End to End test
  @admin
  Scenario: TC01 Post ile Vice Dean Ekleme Testi
    Given Vice dean eklemek icin Post request hazirligi yapilir
    And Gonderilecek Vice dean bilgileri hazirlanir
    When Vice dean eklemek icin Post request gonderilir
    Then Vice dean Bilgileri dogrulanir

  Scenario Outline: TC01 Databasedeki Vice deani Dogrulama
    Given connect to database
    When username "<username>" ile vice deani getir
    Then vice dean bodynin bunlari icerdigini dogrula birthday "<birthday>", birthplace "<birthplace>", gender "<gender>", name "<name>", phoneNumber"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username | birthday   | birthplace | gender | name       | phoneNumber | ssn | surname |
      | username | 2002-01-24 | izmir      | 0      | mehmet ali | phoneNumber | ssn | karasu  |