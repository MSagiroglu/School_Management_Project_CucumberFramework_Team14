@viceDean
Feature: US10 Api Testi
  @Us10Tc01Api

Scenario: Vice Dean ders programı oluşturabilmelidir.
    Given  kulanici lesson program api icin base url olusturur
    And kullanici lesson pragram expected data yi olusturur
    And kullanici vice dean ile post request yaparak bir lesson program olusturur
    Then kullanici lesson programi dogrulama yapar

