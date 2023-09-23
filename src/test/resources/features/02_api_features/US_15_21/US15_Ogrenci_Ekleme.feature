@viceDean
Feature: Ogrenci Ekleme Tesi

  Scenario: Ogrenci basarili bir sekilde eklenebilmeli
    Given Ogrenci eklemek icin Post request hazirligi yapilir
    And Gonderilecek ogrenci bilgileri hazirlanir
    When Ogrenci eklemek icin Post request gonderilir
    Then Ogrenci bilgileri dogrulanir


  Scenario: Ogrenci Olusturabilme Kaydinin DataBase ile dorgulanmasi
    Given ogrenci kaydi icn DataBase baglan
    When username username ile ogrenci bilglerini getir
    Then Database bilgileri dogrulanir





