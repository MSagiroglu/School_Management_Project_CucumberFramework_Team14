@Us21
Feature: US21 Students Choose Lesson Grades And Announcement

  Background:
    Given kullanici Managementonschools sayfasina gider
    And kullanici 2 saniye bekler

  Scenario: TC01 Students choose lesson grades and announcement
    * kullanici login butonuna basar
    * kullanici ogrenci olarak giris yapar
    * kullanici menu butonuna tiklayarak lesson management secenegine tiklar
    * istedigi dersi secer ve submit butonuna tiklar
    * ogrenci bir daha menuye gider ve grades and announcements segenegine tiklar
    * ogrenci student info list bolumunde kendi bilgilerini gorur
    * ogrenci meet list bolumunde danismanin kendisi icin olusturdugu gorusme saatini gorur
    * ogrenci tekrardan yukari sagdaki menu butonuna basar
    * ogrenci soldaki logout butonuna tiklar ve cikis yapar


