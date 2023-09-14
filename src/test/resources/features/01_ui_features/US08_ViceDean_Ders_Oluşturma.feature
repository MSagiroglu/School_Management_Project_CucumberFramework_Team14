Feature: Vice Dean Ders Olusturma
  Background: Login islemleri
    Given kullanici anasayfaya gider
    And login butonuna tiklar
    And username alanina "Team_14 V-Dean" girer
    And password alanina "Team_14 V-Dean" girer
    And login_butonuna_tiklar

  Scenario: US08_TC01_Lesson Ders Olusturma
    Given lessons butonuna tiklar
    And lesson kutucuguna tiklar
    And lesson kutucuguna ders adi girer
    And Zorunlu ders ise kısmını isaretler
    And Credit Score name kutucuğuna tıklar
    And submit_butonuna_tiklar
    And lesson_created_mesajını görür
    And Kullanici sayfayi kapatir

  Scenario: US08_TC02_Vice Dean ders  adını girmeden ders oluşturamamalıdır
    Given lessons butonuna tiklar
    And lesson kutucuguna tiklar
    And Zorunlu ders ise kısmını isaretler
    And Credit Score name kutucuğuna tıklar
    And submit_butonuna_tiklar
    And Kullanici sayfayi kapatir

  Scenario: US08_TC03_Vice Dean dersin Credit Score girmeden ders oluşturamamalıdır
    Given lessons butonuna tiklar
    And lesson kutucuguna tiklar
    And lesson kutucuguna ders adi girer
    And Zorunlu ders ise kısmını isaretler
    And submit_butonuna_tiklar
    And Kullanici sayfayi kapatir




