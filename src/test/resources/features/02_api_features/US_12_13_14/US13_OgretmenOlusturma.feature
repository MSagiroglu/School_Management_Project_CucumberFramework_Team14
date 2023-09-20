
Feature: US13 API Vice Dean ogretmen olusturabilmelidir.

  Scenario: Ogretmen basarili bir sekilde eklenebilmelidir
    Given Post request ile ogretmen olusturulur
    And Gonderilecek Teacher bilgileri hazirlanir
    When Teacher eklemek icin Post request gonderilir
    Then Teacher bilgileri dogrulanir


    Scenario: Eksik girilen ogretmen bilgileri ile kayit olusturulamamalidir
      Given Post request ile ogretmen olusturulur
      And Gonderilecek eksik Teacher bilgileri hazirlanir
      When Eksik bilgilerle teacher eklemek icin Post request gonderilir
      Then kayit olusturulamadigi dogrulanir