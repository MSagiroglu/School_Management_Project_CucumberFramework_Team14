@API21
Feature: Students Choose Lesson Grades And Announcement

  Scenario: Ders basarili bir sekilde eklenebilmeli
    Given Ders eklemek icin Post request hazirligi yapilir
    And Gonderilecek ders bilgileri hazirlanir
    When Ders eklemek icin Post request gonderilir
    Then Ders bilgileri dogrulanir