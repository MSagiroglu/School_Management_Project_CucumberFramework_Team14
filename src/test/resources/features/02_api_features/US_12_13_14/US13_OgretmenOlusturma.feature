@viceDean
Feature: US13 API Vice Dean ogretmen olusturabilmelidir.

  @us13apitc01
  Scenario: Ogretmen basarili bir sekilde eklenebilmelidir
    Given Post request ile ogretmen olusturulur
    And Gonderilecek Teacher bilgileri hazirlanir
    When teacher eklemek icin post request gonderilir
    Then Teacher bilgileri dogrulanir

  @us13apitc02
  Scenario: Eksik girilen ogretmen bilgileri ile kayit olusturulamamalidir
    Given Post request ile ogretmen olusturulur
    And Gonderilecek eksik Teacher bilgileri hazirlanir
    When Eksik bilgilerle teacher eklemek icin Post request gonderilir
    Then kayit olusturulamadigi dogrulanir

  @us13apitc03
  Scenario: Yanlis girilen ogretmen bilgileri ile kayit olusturulamamalidir
    Given Post request ile ogretmen olusturulur
    And Gonderilecek yanlis Teacher bilgileri hazirlanir
    When Eksik bilgilerle teacher eklemek icin Post request gonderilir
    Then eksik bilgilerle kayit olusturulamadigi dogrulanir


  @US13DBTEST
  Scenario Outline: Olusturulan ogretmen kaydinin Database dogrulamasi yapilir
    Given ogretmen bilgileri icin Database baglan
    When kaydi yapilan ogretmeni username "<username>" ile  getir
    Then bodynin bunlari icerdigini dogrula  birthplace "<birthplace>", name "<name>", phoneNumber"<phoneNumber>", ssn"<ssn>", surname"<surname>", username "<username>"
    Examples:
      | username      | birthplace | name   | phoneNumber  | ssn         | surname |
      | Team14teacher | ankara     | team14 | 324-525-2532 | 234-75-5675 | teacher |



