@admin
Feature: US_01 Guest User (Post Request) Ekleme API Testleri

  @ApiPositive
  Scenario: TC_01 Guest User basarili bir sekilde eklenebilmeli
    Given Guest User eklemek icin Post request hazirligi yapilir
    And Gonderilecek Guest User bilgileri hazırlanır
    When Guest User eklemek icin Post request gonderilir
    Then Guest User Post Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.


  Scenario: TC_02 Guest User name girmeden eklenememeli
    Given Guest User eklemek icin Post request hazirligi yapilir
    And Gonderilecek Guest User "name" olmadan bilgileri hazırlanır
    When Guest User eklemek icin "name" olmadan Post request gonderilir
    Then Guest User "name" girmeden Post Response Bilgilerinin getirilemedigi dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.