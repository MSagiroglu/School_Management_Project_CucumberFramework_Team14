@admin @Us22ApiDB @apiDB22_23
Feature: US22 Api ve Database Testi
  @Us22Tc01Api
  Scenario: TC01 Post ile Admin Ekleme Testi
    Given Admin eklemek icin Post request hazirligi yapilir
    And Gonderilecek Admin bilgileri hazirlanir
    When Admin eklemek icin Post request gonderilir
    Then Admin Bilgileri dogrulanir

  @Us22Tc02Api
  Scenario: TC02 Gelecek tarihli Date Of Birth ile Apide Admin Ekleyememe
    Given Admin eklemek icin Post request hazirligi yapilir
    And Gonderilecek Admin bilgilerinde gelecek tarihli date of birth girilir
    When Admin eklemek icin Post request gonderilir
    Then Status Kodunun 400 oldugu dogrulanir

  @Us22Tc03Api
  Scenario: TC03 Onceden girilmis telefon no ile Apide Admin Ekleyememe
    Given Admin eklemek icin Post request hazirligi yapilir
    And Gonderilecek Admin bilgilerinde onceden girilmis telefon no girilir
    When Admin eklemek icin Post request gonderilir
    Then Status Kodunun 409 oldugu dogrulanir

  @Us22Tc01Database
  Scenario Outline: TC01 Databasedeki Admin Dogrulama
    Given database e baglan
    When username "<username>" ile admini getir
    Then bodynin bunlari icerdigini dogrula birthday "<birthday>", birthplace "<birthplace>", gender "<gender>", name "<name>", phoneNubmer"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username | birthday   | birthplace | gender | name       | phoneNumber | ssn | surname |
      | username | 2002-01-24 | bursa      | 0      | mehmet ali | phoneNumber | ssn | karasu  |










