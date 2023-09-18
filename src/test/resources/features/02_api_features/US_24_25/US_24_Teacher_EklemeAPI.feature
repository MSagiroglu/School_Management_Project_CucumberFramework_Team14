@US24API
  Feature: Admin tarafindan teacher eklenebilme testi
    Scenario: Admin basarili bir sekilde teacher ekleyebilmeli
      Given Teacher eklemek için post request hazirligi yapilir
      And Gonderilecek teacher bilgileri hazirlanir
      When Teacher eklemek icin Post request gonderilir
      Then Kaydedilen teacher'a ait bilgiler dogrulanir