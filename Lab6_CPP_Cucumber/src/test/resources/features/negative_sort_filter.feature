Feature: Negative — Sortare și filtrare produse

  @Negative06 @CloseBrowser
  Scenario: TEST-06 — Sortarea produselor după preț NU funcționează
    Given utilizatorul acceseaza pagina Mens
    When pagina Mens este incarcata complet
    And utilizatorul salveaza lista de preturi curente
    And utilizatorul selecteaza sortarea dupa pret crescator
    Then lista de preturi ramane neschimbata
