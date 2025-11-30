Feature: TEST-04 — Validare produse in cos

  @Test04 @CloseBrowser
  Scenario: TEST-04 — Validare produs adaugat in cos
    Given utilizatorul acceseaza pagina Mens
    When pagina Mens este incarcata complet
    And utilizatorul adauga primul produs in cos
    Then produsul din cos trebuie sa fie acelasi cu cel adaugat
