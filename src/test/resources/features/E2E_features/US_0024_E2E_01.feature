@E2E
Feature: US_0024_E2E API-Database Testi

  @admin
  Scenario: TC01 US_0024_E2E UI-Database Testi
    Given Admin Login Olur
    When Admin Teacher ile ilgili bilgileri girer
    And Admin submit tuşuna basar

  Scenario: TC02 US_0024_E2E UI-Database Testi
    When Admin Database bilgileri icin baglantı kurulur.
    Then Admin bilgilerinin database icinde olup olmadigi dogrulanir.