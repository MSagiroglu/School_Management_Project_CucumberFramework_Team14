@111
  Feature: Dean Ekleme Testi
    Scenario: Dean basarili bir sekilde eklenebilmeli
      Given Dean eklemek icin Post request hazirligi yapilir
      And Gonderilecek Dean bilgileri hazırlanır
      When Dean eklemek icin Post request gonderilir
      Then Dean Bilgileri dogrulanir