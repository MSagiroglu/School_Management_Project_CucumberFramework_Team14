@admin @US24API
  Feature: Admin tarafindan teacher eklenebilme testi
    Scenario: Admin basarili bir sekilde teacher ekleyebilmeli
      Given Teacher eklemek için post request hazirligi yapilir
      And Gonderilecek teacher bilgileri hazirlanir
      When Teacher eklemek icin Post request gonderilir
      Then Kaydedilen teacher'a ait bilgiler dogrulanir
      When Admin Database bilgileri icin baglantı kurulur.
      Then Admin bilgilerinin database icinde olup olmadigi dogrulanir.


    @admin @US24APINegatif
    Scenario: Ders seçimi yapılmadan öğretmen ekleyememe
      Given Teacher eklemek için post request hazirligi yapilir
      And Ders seçimi yapılmadan öğretmen bilgileri gönderilir
      When Öğretmen eklemek icin Post request gonderilir
      Then Status kodunun 400 olduğu doğrulanır.