Feature: Functionalitatea de căutare

  @negative
  Scenario Outline: Căutare cu text inexistent nu returnează rezultate
    When se introduce textul "<text_invalid>" în bara de căutare
    And se apăsa Enter
    Then nu se afișează niciun rezultat
    And apare mesajul "nu a returnat niciun document"

    Examples:
      | text_invalid |
      | ++++++       |


  @did_you_mean
  Scenario Outline: Utilizarea sugestiei Did You Mean
    When se introduce textul "<gresit>" în bara de căutare
    And se apăsa Enter
    And aștept sugestia DidYouMean "<corect>"
    And selectez sugestia DidYouMean
    Then rezultatul conține "<corect>"

    Examples:
      | gresit   | corect    |
      | tehincal | tehnical  |


  @suggestions
  Scenario Outline: Apariția listei de sugestii la tastarea unui cuvânt cheie
    When se introduce textul "<text>" în bara de căutare
    Then trebuie să apară o listă de sugestii pentru "<text>"
    And sugestiile conțin variante similare cuvântului "<text>"

    Examples:
      | text     |
      | Technical |
