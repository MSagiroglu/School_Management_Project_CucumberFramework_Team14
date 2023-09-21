@admin
Feature: US_02 Admin olarak User Student Get Request and Delete Request API sorgu
  @e2ePositive @ApiPositive
  Scenario: TC_01 Admin oluşturulan guest usera Get request yapma ve Database sorgulama
    Given Guest User icin Get request hazirligi yapilir
    And Sorgulanacak Guest User bilgileri hazırlanır
    When Sorgulamak icin Get request gonderilir
    Then Guest User Get Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.

  @ApiPositive
  Scenario: TC_02 Oluşturulan guest user Delete request yapma
    Given Guest User icin Delete request hazirligi yapilir
    When Silmek icin Delete request gonderilir
    Then Guest User Delete Response Bilgileri dogrulanir
    When Guest User Database bilgileri icin baglantı kurulur.
    Then Guest User bilgilerinin database icinde olup olmadigi dogrulanir.