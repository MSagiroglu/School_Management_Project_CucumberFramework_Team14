
  Feature: Vice Dean Ogretmen Bilgilerini Goruntuleyebilmeli ve Guncelleyebilmelidir

    Scenario: Ogretmen bilgileri goruntulenebilmelidir
      Given Post request ile ogretmen olusturulur
      And Gonderilecek Teacher bilgileri hazirlanir
      When Teacher eklemek icin Post request gonderilir
      Then Ogretmenin istenen bilgilerinin goruntulendigi dogrulanir



      Scenario: Ogretmen bilgileri guncellenebilmelidir
        Given Put request ile guncellenecek ogretmen bilgileri gonderilir
        Then guncellenen ogretmen bilgileri dogrulanir

