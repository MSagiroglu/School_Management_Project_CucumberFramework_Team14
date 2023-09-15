Feature: US24 Teacher Ekleme
  @Us24TC01
  Scenario: TC01 Teacher Ekleme
    Given Admin Login Olur
    When Admin Teacher ile ilgili bilgileri girer
    And Admin submit tuşuna basar


  @Us24TC02
  Scenario: Admin ders seçmeden öğretmen kaydetmemeli
    Given Admin Login Olur
    When Admin Teacher ile ilgili bilgileri ders seçimi yapmadan girer
    Then Kaydın oluşmadığına dair hata ve ekran görüntüsü alınır.
