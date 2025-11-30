Feature: Verificare carduri produs in cos (MiniCart)

  @Test02 @CloseBrowser
  Scenario: TEST-02 — Verificare card produs in cos
    Given utilizatorul acceseaza pagina Mens
    When adauga primul produs in cos
    Then cardul produsului din cos trebuie sa fie valid
