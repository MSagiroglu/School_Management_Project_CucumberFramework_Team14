@E2E_US22_23
Feature: US22 API ve Database End to End test
  @admin
  Scenario: API Admin Ekleme
    Given Admin eklemek icin Post request hazirligi yapilir
    And Gonderilecek Admin bilgileri hazirlanir
    When Admin eklemek icin Post request gonderilir
    Then Admin Bilgileri dogrulanir

  Scenario Outline: TC01 Databasedeki Admin Dogrulama
    Given database e baglan
    When username "<username>" ile admini getir
    Then bodynin bunlari icerdigini dogrula birthday "<birthday>", birthplace "<birthplace>", gender "<gender>", name "<name>", phoneNubmer"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username | birthday   | birthplace | gender | name       | phoneNumber | ssn | surname |
      | username | 2002-01-24 | bursa      | 0      | mehmet ali | phoneNumber | ssn | karasu  |