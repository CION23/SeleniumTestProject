Feature: Teste negative produse

  @Negative05 @CloseBrowser
  Scenario: TEST-05 — Adaugare produs fara selectare marime
    Given utilizatorul acceseaza pagina Mens
    When pagina Mens este incarcata complet
    And utilizatorul deschide detaliile primului produs
    And utilizatorul adauga produsul in cos fara selectarea marimii
    Then produsul este adaugat in cos desi marimea nu a fost selectata
