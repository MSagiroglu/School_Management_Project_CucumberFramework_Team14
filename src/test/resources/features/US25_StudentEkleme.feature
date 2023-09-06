@US_24
Feature: Admin sisteme Student ekleyebilmeli
  Background:
    Given Admin sisteme admin olarak giriş yapar

    @US_25_PS
    Scenario: TC_01 Admin sisteme student kaydedebilmelidir
      When Admin kullanıcı sisteme giriş yapar.
      And Student ile ilgili gerekli bilgileri doldurur.
      Then Olusturulan Student'ın sisteme kaydının gerçekleştirildiği doğrulanır.

      @_25_NS
      Scenario: TC_02 Student kaydı ders seçimi yapılmadan oluşturulamamalı
        When Admin kullanıcı sisteme giriş yapar.
        And Student ile ilgili bilgileri advisor teacher seçmeden doldurur.
        Then Student kaydının oluşmadığını kontrol eder.
