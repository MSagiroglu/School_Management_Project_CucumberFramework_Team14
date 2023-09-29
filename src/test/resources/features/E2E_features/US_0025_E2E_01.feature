
Feature:  US_0025_E2E UI-Database Testi
  @UI
  Scenario: TC01 US_0024_E2E UI-Database Testi
    Given Admin sisteme admin olarak giriş yapar
    Then Student ile ilgili gerekli bilgileri doldurur.
    And Olusturulan Student'ın sisteme kaydının gerçekleştirildiği doğrulanır.

  Scenario: TC02 US_0024_E2E UI-Database Testi
    When Admin öğrenci database bilgileri icin baglantı kurulur.
    Then Admin öğrenci bilgilerinin database icinde olup olmadigi dogrulanir.