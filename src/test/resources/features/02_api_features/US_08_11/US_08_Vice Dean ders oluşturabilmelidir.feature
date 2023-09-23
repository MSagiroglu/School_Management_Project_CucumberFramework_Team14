@viceDean
Feature: US08 Api Testi

  @Us08Tc01Api @viceDean
  Scenario: TC01 Vice Dean ders olusturabilmelidir.
    Given  kulanici api icin base url olusturur
    And kullanici expected data yi olusturur
    And kullanici vice dean ile post request yaparak bir lesson olusturur
    Then kullanici dogrulama yapar
    When Lesson Database bilgileri icin baglantı kurulur.
    Then Lesson bilgilerinin database icinde olup olmadigi dogrulanir.

