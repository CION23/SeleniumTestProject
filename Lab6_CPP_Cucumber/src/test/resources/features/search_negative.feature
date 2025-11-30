Feature: Negative — Căutare produse

  @Negative07 @CloseBrowser
  Scenario: TEST-07 — Căutarea unui produs existent duce la pagina 404
    Given utilizatorul acceseaza pagina Mens
    When pagina Mens este incarcata complet
    And utilizatorul introduce in search "Analog Watch"
    And utilizatorul apasa butonul de cautare
    Then utilizatorul este redirectionat la pagina 404
