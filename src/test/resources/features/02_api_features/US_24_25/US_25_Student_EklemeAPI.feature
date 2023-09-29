@admin @US25API
Feature: Admin tarafindan student eklenebilme testi

  @Us25Tc01Api
  Scenario: Admin basarili bir sekilde student ekleyebilmeli
    Given Student eklemek için post request hazirligi yapilir
    And Gonderilecek student bilgileri hazirlanir
    When Student eklemek icin Post request gonderilir
    Then Kaydedilen student'a ait bilgiler dogrulanir

  Scenario: Olusturulan Ogrencinin databasede olup olmadigi dogrulanir
    When Admin öğrenci database bilgileri icin baglantı kurulur.
    Then Admin öğrenci bilgilerinin database icinde olup olmadigi dogrulanir.

 # @admin @US25APINegatif
 # Scenario: Advisor Teacher seçimi yapılmadan öğrenci ekleyememe
 #   Given Student eklemek için post request hazirligi yapilir
 #   And Advisor Teacher seçimi yapılmadan öğrenci bilgileri hazırlanır
 #   When Öğrenci eklemek icin Post request gonderilir
 #   Then Status kodunun 400 olduğu doğrulaması yapılır