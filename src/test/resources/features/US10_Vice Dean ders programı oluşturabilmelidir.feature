Feature: Vice Dean Ders Olusturma
  Background: Login islemleri
    Given kullanici anasayfaya gider
    And login butonuna tiklar
    And username alanina "Team_14 V-Dean" girer
    And password alanina "Team_14 V-Dean" girer
    And login_butonuna_tiklar
    And  Lessons Program butonuna tıklar

  @Us10Tc01
  Scenario: Vice Dean ders programı oluşturabilmelidir.
    Given   Choose Lessons kutucuguna tiklar ve Ders adini girer
    And Choose Education Term açılır menüsünden eğitim dönemini seçer
    And Choose day kutucuguna tiklar ve day adini girer
    And Start Time menüsünden ders icin baslama saatini girer
    And Stop Time menüsünden ders icin bitiş saatini girer
    And Submit butonuna tiklar
    And (Created Lesson Program)_yazisini_goruntuler

  @Us10Tc02
  Scenario: Vice Dean ders programı oluşturabilmelidir.
    And Choose Education Term açılır menüsünden eğitim dönemini seçer
    And Choose day kutucuguna tiklar ve day adini girer
    And Start Time menüsünden ders icin baslama saatini girer
    And Stop Time menüsünden ders icin bitiş saatini girer



