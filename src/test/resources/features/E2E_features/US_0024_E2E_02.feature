@E2E
Feature: Admin tarafindan teacher eklenebilme testi
  @admin
  Scenario:TC01 US_0024_E2E API-Database Testi
    Given Teacher eklemek için post request hazirligi yapilir
    And Gonderilecek teacher bilgileri hazirlanir
    When Teacher eklemek icin Post request gonderilir
    Then Kaydedilen teacher'a ait bilgiler dogrulanir

  Scenario: TC02 US_0024_E2E API-Database Testi
    When Admin Database bilgileri icin baglantı kurulur.
    Then Admin bilgilerinin database icinde olup olmadigi dogrulanir.