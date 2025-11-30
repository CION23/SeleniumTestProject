Feature: Mens page tests

  @Test01 @CloseBrowser
  Scenario: TEST-01 — Verificare: incarcare pagină Mens si afisare produse
    Given utilizatorul acceseaza pagina Mens
    When pagina Mens este incarcata complet
    Then numarul de produse afisate trebuie sa fie mai mare ca 0
