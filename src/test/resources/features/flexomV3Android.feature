@flexomV3Android
Feature:Se connecter à flexomV3

  @APPSV2-1128
  Scenario:Tentative de connexion avec succes
    Given lutilisateur souhaite se connecter à l'application
    When il accède à l'application Overkiz
    And utilisateur voit les champs "Adresse E-mail" And "Mot de passe" sur la page d'accueil
    Then  l'utilisateur saisit ses informations de connexion
    And l'utilisateur se connecte à son compte

