
Feature: Admin sisteme Student ekleyebilmeli
  Background:
    Given Admin sisteme admin olarak giriş yapar

    @US_25_PS
    Scenario: TC_01 Admin sisteme student kaydedebilmelidir
      Then Student ile ilgili gerekli bilgileri doldurur.
      And Olusturulan Student'ın sisteme kaydının gerçekleştirildiği doğrulanır.

      @US_25_NS
      Scenario: TC_02 Student kaydı ders seçimi yapılmadan oluşturulamamalı
        Then Student ile ilgili bilgileri advisor teacher seçmeden doldurur.
        And Student kaydının oluşmadığını kontrol eder.
