Feature: AliExpress Basic Operations

  Scenario: Verify URL and Make a Phone Call
    Given I am on the AliExpress platform
    When Je vérifie que l'URL est correcte
    Then Je devrais voir la page d'accueil d'AliExpress
    When Je clique sur le bouton pour appeler le service client
    Then Je devrais voir l'écran d'appel téléphonique