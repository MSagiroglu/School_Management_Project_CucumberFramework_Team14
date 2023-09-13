Feature: US24 Teacher Ekleme
  @Us24TC01
  Scenario: TC01 Teacher Ekleme
    Given Admin Login Olur
    When Admin Teacher ile ilgili bilgileri girer
    And Admin submit tuşuna basar
    And Öğretmenin kaydolduğu doğrulanır


  @Us24TC02
  Scenario: Admin ders seçmeden öğretmen kaydetmemeli
    Given Admin login olur
    When Admin Teacher ile ilgili bilgileri ders seçimi yapmadan girer
    And Sistemin öğretmen seçimi yapılmadan kaydetmediği hata mesajı ile doğrulanır.

