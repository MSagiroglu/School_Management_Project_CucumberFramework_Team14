@admin @US25API
Feature: US_0025_E2E API-Database Testi

  @Us25Tc01Api
  Scenario: Admin basarili bir sekilde student ekleyebilmeli
    Given Student eklemek için post request hazirligi yapilir
    And Gonderilecek student bilgileri hazirlanir
    When Student eklemek icin Post request gonderilir
    Then Kaydedilen student'a ait bilgiler dogrulanir

  Scenario: Olusturulan Ogrencinin databasede olup olmadigi dogrulanir
    When Admin öğrenci database bilgileri icin baglantı kurulur.
    Then Admin öğrenci bilgilerinin database icinde olup olmadigi dogrulanir.