Feature: Verificare pagina detalii produs

  @Test03 @CloseBrowser
  Scenario: TEST03 — Verificare deschidere pagina detalii produs
    Given utilizatorul acceseaza pagina Mens
    When pagina Mens este incarcata complet
    When utilizatorul deschide detaliile primului produs
    Then pagina de detalii trebuie sa se deschida corect
