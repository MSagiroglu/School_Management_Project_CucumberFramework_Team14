Feature: Vice Dean Ders Olusturma
  Background: Login islemleri
    Given kullanici anasayfaya gider
    And login butonuna tiklar
    And username alanina "Team_14 V-Dean" girer
    And password alanina "Team_14 V-Dean" girer
    And login_butonuna_tiklar
    Given lessons butonuna tiklar



  @US09_TC01
  Scenario: US09_TC01_DersListesiniGorebilme
    And Vice Dean Lesson Name alanini gorur.


