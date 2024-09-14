Feature: Se connecter

  @APPSV2-1133
  Scenario Outline: Vérification des informations personnelles
    Given Je lance mon app "<tag>"
    Given l'utilisateur souhaite vérifier ses informations personnelles
    When il accède à l'application Overkiz pour accéder à son profil
    Then l'utilisateur peut vérifier ses informations personnelles
    Examples:
      | tag        |
      | aliexpress |



