@viceDean
Feature: Vice Dean Ogretmen Bilgilerini Goruntuleyebilmeli ve Guncelleyebilmelidir

  @us14apitc01
  Scenario: Ogretmen bilgileri goruntulenebilmelidir
    Given Post request ile ogretmen olusturulur
    And Gonderilecek Teacher bilgileri hazirlanir
    When teacher eklemek icin post request gonderilir
    Then Ogretmenin istenen bilgilerinin goruntulendigi dogrulanir


  @us14apitc02
  Scenario: Ogretmen bilgileri guncellenebilmelidir
    Given Put request ile guncellenecek ogretmen bilgileri gonderilir
    Then guncellenen ogretmen bilgileri dogrulanir

