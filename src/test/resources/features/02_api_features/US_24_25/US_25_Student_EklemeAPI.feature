@US24API
Feature: Admin tarafindan student eklenebilme testi
  Scenario: Admin basarili bir sekilde student ekleyebilmeli
    Given Student eklemek için post request hazirligi yapilir
    And Gonderilecek student bilgileri hazirlanir
    When Student eklemek icin Post request gonderilir
    Then Kaydedilen student'a ait bilgiler dogrulanir