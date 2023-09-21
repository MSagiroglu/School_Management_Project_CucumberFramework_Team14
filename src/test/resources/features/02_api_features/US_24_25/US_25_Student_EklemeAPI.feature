@admin @US25API
Feature: Admin tarafindan student eklenebilme testi
  @Us25Tc01Api
  Scenario: Admin basarili bir sekilde student ekleyebilmeli
    Given Student eklemek için post request hazirligi yapilir
    And Gonderilecek student bilgileri hazirlanir
    When Student eklemek icin Post request gonderilir
    Then Kaydedilen student'a ait bilgiler dogrulanir

  @Us25Tc02Api
  Scenario: TC02 Advisor Teacher seçmeden kayıt olunmamalı
    Given Student eklemek için post request hazirligi yapilir
    And Student kaydı yapılırken advisor teacher seçimi yapılmaz
    Then  Response body'de alacağımız status kodunun 404 oldugu dogrulanir
