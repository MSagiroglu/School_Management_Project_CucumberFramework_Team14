Feature: User Student Get Request API sorgu
  @pozitifApi
  Scenario: US_02 Oluşturulan guest user Get request yapma
    Given Guest User icin Get request hazirligi yapilir
    And Sorgulanacak Guest User bilgileri hazırlanır
    When Sorgulamak icin Get request gonderilir
    Then Guest User Bilgileri dogrulanir