@US_24
Feature: Admin sisteme Teacher ekleyebilmeli
  Background:
    Given Admin sisteme admin olarak giriş yapar

    @US_24_PS
    Scenario: TC_01 Admin sisteme teacher kaydedebilmelidir
      When Admin kullanıcı sisteme giriş yapar.
      And Teacher ile ilgili gerekli bilgileri doldurur.
      Then Olusturulan Teacher'ın sisteme kaydının gerçekleştirildiği doğrulanır.

      @_24_NS
      Scenario: TC_02 Teacher kaydı ders seçimi yapılmadan oluşturulamamalı
        When Admin kullanıcı sisteme giriş yapar.
        And Teacher ile ilgili bilgileri ders seçimi yapmadan doldurur.
        Then Öğretmen kaydının oluşmadığını kontrol eder.
