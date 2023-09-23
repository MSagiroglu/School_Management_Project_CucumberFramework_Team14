
Feature: US_001 ve US_002 E2E Testler
  @UI
  Scenario: TC_01  UI Aday ogrenciler sisteme kayit olabilmelidir.
    Given Guest User Anasayfada register butonuna tiklar
    When Guest User Register sayfasındaki gerekli alanları doldurur.
    Then Aday ogrencinin kaydının basarili bir şekilde gerçeklestigi dogrulanır.
@admin
  Scenario: TC_02 API ve Database Admin oluşturulan guest usera Get request yapma ve Database sorgulama
    Given Guest User icin Get request hazirligi yapilir
    And Sorgulanacak Guest User bilgileri hazırlanır
    When Sorgulamak icin Get request gonderilir
    Then Guest User Get Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.

 @admin
  Scenario: TC_03 API ve Database Oluşturulan guest user Delete request yapma
    Given Guest User icin Delete request hazirligi yapilir
    When Silmek icin Delete request gonderilir
    Then Guest User Delete Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.

