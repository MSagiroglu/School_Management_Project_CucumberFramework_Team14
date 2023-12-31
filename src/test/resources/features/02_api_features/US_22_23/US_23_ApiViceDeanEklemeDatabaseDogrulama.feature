@admin @Us23ApiDB @apiDB22_23
Feature: US23 Api Testi
  @Us23Tc01Api
  Scenario: TC01 Post ile Vice Dean Ekleme Testi
    Given Vice dean eklemek icin Post request hazirligi yapilir
    And Gonderilecek Vice dean bilgileri hazirlanir
    When Vice dean eklemek icin Post request gonderilir
    Then Vice dean Bilgileri dogrulanir

  @Us23Tc02Api
  Scenario: TC02 Gelecek tarihli Date Of Birth ile Apide Vice dean Ekleyememe
    Given Vice dean eklemek icin Post request hazirligi yapilir
    And Gonderilecek Vice dean bilgilerinde gelecek tarihli date of birth girilir
    When Vice dean eklemek icin Post request gonderilir
    Then Responsedaki status Kodunun 400 oldugu dogrulanir

  @Us23Tc03Api
  Scenario: TC03 Onceden girilmis ssn no ile Apide Vice dean Ekleyememe
    Given Vice dean eklemek icin Post request hazirligi yapilir
    And Gonderilecek Vice dean bilgilerinde onceden girilmis ssn no girilir
    When Vice dean eklemek icin Post request gonderilir
    Then Responsedaki status Kodunun 409 oldugu dogrulanir

  @Us23Tc01Database
  Scenario Outline: TC01 Databasedeki Vice deani Dogrulama
    Given connect to database
    When username "<username>" ile vice deani getir
    Then vice dean bodynin bunlari icerdigini dogrula birthday "<birthday>", birthplace "<birthplace>", gender "<gender>", name "<name>", phoneNumber"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username | birthday   | birthplace | gender | name       | phoneNumber | ssn | surname |
      | username | 2002-01-24 | izmir      | 0      | mehmet ali | phoneNumber | ssn | karasu  |