@smokeIos
Feature: Se connecter à overkiz
  @kizconnectIos @hexaconnectIos @wisniowskiIos @flexomV3Ios
  Scenario Outline:Tentative de connexion avec succes
    Given lutilisateur souhaite se connecter à l'application Ios

    Examples:
      | tag             |
      | @kizconnectIos  |
      | @hexaconnectIos |
      | @wisniowskiIos  |
      | @flexomV3Ios     |
